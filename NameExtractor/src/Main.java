import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class reads a text file, extracts the first word from each line,
 * and stores these words in an ArrayList. Finally, it prints the list of extracted words.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.hasMoreTokens()) {
                    String name = tokenizer.nextToken(); 
                    names.add(name); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
