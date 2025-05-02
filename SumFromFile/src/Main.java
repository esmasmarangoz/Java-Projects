import java.util.*;
import java.io.*;

/**
 * This class reads integers from a text file where numbers are separated by commas,
 * and calculates the sum of these numbers.
 */
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        try {
            BufferedReader esma = new BufferedReader(new FileReader("C:\\input.txt"));
            String line;
            while ((line = esma.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    sum += Integer.parseInt(token);
                }
            }
            esma.close(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        
        System.out.println("The sum is: " + sum); 
    }
}
