import java.util.*;

public class LongMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first and second numbers
        System.out.print("Enter first number: ");
        long number1 = scanner.nextLong();
        System.out.print("Enter second number: ");
        long number2 = scanner.nextLong();

        // Linked lists to store the digits of the input numbers
        LinkedList<Long> firstNumberDigits = new LinkedList<>();
        LinkedList<Long> secondNumberDigits = new LinkedList<>();

        int firstNumberDigitCount = 0;
        int secondNumberDigitCount = 0;

        long tempFirstNumber = number1;
        long tempSecondNumber = number2;

        // Extract digits of the first number and store them in a linked list
        while (number1 > 0) {
            long digit = number1 % 10;
            firstNumberDigits.addFirst(digit);
            number1 /= 10;
            firstNumberDigitCount++;
        }

        // Extract digits of the second number and store them in a linked list
        while (number2 > 0) {
            long digit = number2 % 10;
            secondNumberDigits.addFirst(digit);
            number2 /= 10;
            secondNumberDigitCount++;
        }

        // Multiply the first number by each digit of the second number (right to left)
        LinkedList<Long> multiplicationResult = new LinkedList<>();
        for (int j = 0; j < secondNumberDigits.size(); j++) {
            long multiplication = tempFirstNumber * secondNumberDigits.get(j);
            multiplicationResult.addFirst(multiplication);
        }

        // Shift each intermediate result according to its digit position
        LinkedList<Long> actualResult = new LinkedList<>();
        for (int i = 0; i < multiplicationResult.size(); i++) {
            long number = multiplicationResult.get(i) * (long) Math.pow(10, i);
            actualResult.add(number);
        }

        // Sum all the shifted results to get the final product
        long finalSum = 0;
        for (long result : actualResult) {
            finalSum += result;
        }

        // Formatting output to simulate paper-style multiplication
        int tempDigitCounter = Math.max(firstNumberDigitCount, secondNumberDigitCount);

        // Print first number (aligned)
        for (int i = 0; i < secondNumberDigitCount; i++) {
            System.out.print(" ");
        }
        System.out.println(tempFirstNumber);

        // Print second number (aligned)
        for (int i = 0; i < firstNumberDigitCount; i++) {
            System.out.print(" ");
        }
        System.out.println(tempSecondNumber);

        System.out.println("x");

        // Separator line
        for (int i = 0; i < tempDigitCounter * 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Print intermediate multiplication steps
        int k = 0;
        int temp = secondNumberDigitCount * 2;
        int tempSecondNumberDigitCount = secondNumberDigitCount;
        while (secondNumberDigitCount > 0) {
            for (int i = 0; i < secondNumberDigitCount; i++) {
                System.out.print(" ");
            }
            secondNumberDigitCount--;
            System.out.println(multiplicationResult.get(k));
            k++;
        }

        // Print final result line
        System.out.println("+");
        for (int i = 0; i < temp; i++) {
            System.out.print("-");
        }
        System.out.println();

        // Final alignment for the total sum
        long tempFinal = finalSum;
        long finalDigitCounter = 0;
        while (finalSum > 0) {
            finalSum /= 10;
            finalDigitCounter++;
        }

        long diff = 0;
        long sum = firstNumberDigitCount + tempSecondNumberDigitCount;
        if (sum > finalDigitCounter) {
            diff = sum - finalDigitCounter;
            for (int i = 0; i < diff; i++) {
                System.out.print(" ");
            }
        }
        System.out.println(tempFinal);
        scanner.close();
    }
}
