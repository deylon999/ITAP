package org.example;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import java.util.Properties;
import java.io.InputStream;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        logger.info("Программа запущена");
        readBuildPassport();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        logger.info("Введено: {}", input);
        
        String reversed = StringUtils.reverse(input);
        String capitalized = StringUtils.capitalize(input);
        
        logger.info("Перевернуто: {}", reversed);
        logger.info("С заглавной: {}", capitalized);
        
        logger.info("Программа завершена");
        scanner.close();
    }
    
    private static void readBuildPassport() {
        try (InputStream input = Main.class.getClassLoader()
                .getResourceAsStream("build-passport.properties")) {
            if (input != null) {
                Properties props = new Properties();
                props.load(input);
                
                logger.info("User: {}", props.getProperty("build.user"));
                logger.info("OS: {}", props.getProperty("build.os"));
                logger.info("Java: {}", props.getProperty("build.java.version"));
                logger.info("Build Time: {}", props.getProperty("build.time"));
                logger.info("Message: {}", props.getProperty("build.message"));
            }
        } catch (Exception e) {
            logger.warn("build-passport.properties не найден");
        }
    }
}