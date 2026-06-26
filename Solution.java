import java.util.*;
import java.util.regex.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        Pattern pattern =Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> emails = new ArrayList<>();
            while (matcher.find()) {
                emails.add("\"" + matcher.group() + "\"");
            }
            results.add("{\"emails\":[" + String.join(",", emails) + "]}");
        }
        scanner.close();
        System.out.print("[");
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i));
            if (i < results.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
