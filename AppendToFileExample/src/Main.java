import java.util.*;
import java.io.*;

/**
 * This class allows the user to either append text to an existing file
 * or create a new file and write text to it. The user chooses between appending or creating
 * a new file, then enters the text to be written.
 */
public class Main {
    public static void main(String[] args) {
        PrintWriter hey = null;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("A for append or N for new file:");
            char answer = scanner.next().charAt(0);
            boolean x = (answer == 'A');

            hey = new PrintWriter(new FileOutputStream("es.txt", x));

            System.out.println("Enter text:");
            String text = scanner.next();
            hey.write(text);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (hey != null) {
                hey.close();
            }
            scanner.close();
        }
    }
}
