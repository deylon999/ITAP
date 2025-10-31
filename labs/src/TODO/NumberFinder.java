import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Текущая цена $3.1 или 250руб за булку";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
