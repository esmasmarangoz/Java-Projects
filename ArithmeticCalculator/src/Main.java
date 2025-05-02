import java.util.*;
import java.io.*;

/**
 * This class reads arithmetic operations from a text file ("input.txt"),
 * performs the calculations, and writes the results to another text file ("output.txt").
 * Example of input:
 * 12 + 34
 * 24 - 7
 * 16 / 4
 * 13 * 3
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\input.txt"));
            String line;
            while((line = reader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    try {
                        int num = Integer.parseInt(token);
                        numbers.add(num);
                    } catch (NumberFormatException e) {
                        if (token.equals("+") || token.equals("-") || token.equals("–") || token.equals("*") || token.equals("/")) {
                            operators.add(token.charAt(0));
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        for (int i = 0; i < operators.size(); i++) {
            int num1 = numbers.get(i * 2);
            int num2 = numbers.get(i * 2 + 1);
            char operator = operators.get(i);
            String result = "";

            if (operator == '+') {
                result = String.valueOf(num1 + num2);
            } else if (operator == '-' || operator == '–') {  
                result = String.valueOf(num1 - num2);
            } else if (operator == '*') {
                result = String.valueOf(num1 * num2);
            } else if (operator == '/') {
                result = String.valueOf((int)((double) num1 / num2));
            }
            
            results.add(result);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Esma Şevval Marangoz\\Desktop\\Java\\1405derscalısıyom\\output.txt"));
            for (int i = 0; i < operators.size(); i++) {
                int num1 = numbers.get(i * 2);
                int num2 = numbers.get(i * 2 + 1);
                char operator = operators.get(i);
                String result = results.get(i);
                writer.write(num1 + " " + operator + " " + num2 + " = " + result);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }

        System.out.println(numbers);
        System.out.println(operators);
        System.out.println(results);
    }
}
