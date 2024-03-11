import java.util.Arrays;
import java.util.Random;

public class ArraySort {
    public static void main(String[] args) {
        // Create an array to store 10 random numbers
        int[] numbers = new int[10];

        // Generate and store random numbers in the array
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Adjust the bound as needed
        }

        // Display the original array
        System.out.println("Original Array:");
        displayArray(numbers);

        // Sort the array
        Arrays.sort(numbers);

        // Display the sorted array
        System.out.println("Sorted Array:");
        displayArray(numbers);
    }

    // Method to display an array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
