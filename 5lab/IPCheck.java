import java.util.regex.*;

public class IPCheck {
    public static void main(String[] args) {
        String ip = "299.168.0.255";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$");
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            System.out.println("IP корректен");
        } else {
            System.out.println("IP некорректен");
        }
    }
}
