import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * This program demonstrates how to remove duplicate elements from a list of integers.
 */
public class Main {    
    public static void main(String[] args) {
        // Create a list with duplicate integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);

        // Display the original list
        System.out.println("Original List: " + numbers);

        // Remove duplicates from the list
        removeDuplicates(numbers);

        // Display the list after removing duplicates
        System.out.println("List after removing duplicates: " + numbers);
    }

    // Method to remove duplicates from a list
    public static void removeDuplicates(List<Integer> list) {
        // Use a LinkedHashSet to maintain insertion order and remove duplicates
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        list.clear(); // Clear the original list
        list.addAll(set); // Add the elements back to the list without duplicates
    }
}
