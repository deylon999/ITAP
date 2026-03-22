import java.util.Properties
import java.time.LocalDateTime

plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow") version "8.3.5"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation("org.slf4j:slf4j-api:2.0.13")
    
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.example.Main")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.shadowJar {
    manifest {
        attributes(Pair("Main-Class", "org.example.Main"))
    }
}

abstract class PrintInfoTask : DefaultTask() {
    @TaskAction
    fun print() {
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
    }
}

tasks.register<PrintInfoTask>("printInfo") {
    group = "Custom"
    description = "Выводит информацию о проекте"
}

abstract class GenerateBuildPassportTask : DefaultTask() {
    @TaskAction
    fun generate() {
        val props = Properties()
        
        val userName = System.getenv("USERNAME") ?: System.getenv("USER") ?: "unknown"
        props.setProperty("build.user", userName)
        props.setProperty("build.os", System.getProperty("os.name"))
        props.setProperty("build.java.version", System.getProperty("java.version"))
        props.setProperty("build.time", LocalDateTime.now().toString())
        props.setProperty("build.message", "Сборка проекта ${project.name}")
        
        val resourcesDir = project.layout.buildDirectory.dir("resources/main").get().asFile
        resourcesDir.mkdirs()
        val outputFile = resourcesDir.resolve("build-passport.properties")
        
        props.store(outputFile.outputStream(), "Build Passport Information")
        println("Сгенерирован: ${outputFile.absolutePath}")
    }
}

tasks.register<GenerateBuildPassportTask>("generateBuildPassport") {
    group = "build"
    description = "Генерирует build-passport.properties"
}

tasks.named("processResources") {
    dependsOn(tasks.named("generateBuildPassport"))
}