import java.util.regex.*;

public class UpperAfterLower {
    public static void main(String[] args) {
        String text = "helloWorld thisIsJava goodDay";
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("$1!$2!");
        System.out.println(result);
    }
}
