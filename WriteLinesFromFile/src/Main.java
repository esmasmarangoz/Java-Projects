import java.util.*;
import java.io.*;

/**
 * This class takes three lines of input from the user and writes them to a file.
 */
public class Main {
    public static void main(String[] args) {
        try {
            PrintWriter es = new PrintWriter("hi.txt"); // The file will be named 'hi.txt'
            Scanner scan = new Scanner(System.in);
            String line;
            for(int i = 0; i < 3; i++){
                System.out.println("Enter " + (i + 1) + ". line:");
                line = scan.nextLine();
                es.write(line + "\n"); // Adding a newline character to separate lines
            }
            es.close();
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
