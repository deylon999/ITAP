import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\d3\\Desktop\\labs\\labs\\src\\text.txt";
        File file = new File(filePath);
        Map<String, Integer> words = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я0-9]", "");
                if (!word.isEmpty()) {
                    words.put(word, words.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
    }
}
