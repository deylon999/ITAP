import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        String password = "macan4ik";
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Пароль корректен");
        } else {
            System.out.println("Пароль некорректен");
        }
    }
}
