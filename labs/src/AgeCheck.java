class CustomAgeException extends Exception {
    public CustomAgeException(String msg) { super(msg); }
}

public class AgeCheck {
    public static void main(String[] args) {
        int age = 150;
        try {
            if (age < 0 || age > 120) throw new CustomAgeException("Недопустимый возраст!");
            System.out.println("Возраст корректен");
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            ExceptionLogger.log(e);
        }
    }
}
