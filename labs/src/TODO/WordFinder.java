import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Java и JavaScript йоу";
        char letter = 'J';
        Pattern pattern = Pattern.compile("\\b" + letter + "[a-zA-Z]*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
