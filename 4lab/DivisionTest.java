class CustomDivisionException extends Exception {
    public CustomDivisionException(String msg) { super(msg); }
}

public class DivisionTest {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            if (b == 0) throw new CustomDivisionException("Деление на ноль!");
            System.out.println(a / b);
        } catch (CustomDivisionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
