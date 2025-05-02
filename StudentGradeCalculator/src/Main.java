import java.util.*;
import java.io.*;

/**
 * This program reads student names and their grades from an input file,
 * calculates the average grade for each student, and stores the results.
 * 
 * Input file format:
 * Each line in the file contains a student's name followed by two grades.
 * Example:
 * Ozgur Koray SAHINGOZ 78 97
 * Mustafa Bayram 88 91
 * Aydin Secer 62 99
 * Guray YILMAZ 77 88
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Esma Şevval Marangoz\\Desktop\\Java\\1405derscalısıyom\\input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                
                // Reading the name (which might consist of multiple tokens)
                StringBuilder name = new StringBuilder();
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    try {
                        int num = Integer.parseInt(token);
                        grades.add(num);
                        break;  // Stop after encountering the first number
                    } catch (NumberFormatException e) {
                        name.append(token).append(" ");
                    }
                }
                names.add(name.toString().trim());
                
                // Read the remaining grades
                while (tokenizer.hasMoreTokens()) {
                    try {
                        int num = Integer.parseInt(tokenizer.nextToken());
                        grades.add(num);
                    } catch (NumberFormatException e) {}
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Integer> averages = new ArrayList<>();
        for (int i = 0; i < grades.size(); i += 2) {
            int total = grades.get(i) + grades.get(i + 1);
            int average = total / 2;
            averages.add(average);
        }

        // Display the results
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + "'s average grade: " + averages.get(i));
        }
    }
}
