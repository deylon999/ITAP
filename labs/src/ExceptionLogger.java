import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionLogger {
    public static void log(Exception e) {
        try (FileWriter fw = new FileWriter("error_log.txt", true)) {
            fw.write(LocalDateTime.now() + " — " + e.getClass().getName() + ": " + e.getMessage() + "\n");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи лога: " + ex.getMessage());
        }
    }
}
