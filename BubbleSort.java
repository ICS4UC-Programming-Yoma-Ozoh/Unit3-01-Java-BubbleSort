import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads unsorted numbers from a file,
 * sorts them using Bubble Sort, and writes them to a file.
 *
 * @author  Yoma Ozoh
 * @version 1.0
 * @since   2026-11-22
 */
public final class BubbleSort {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private BubbleSort() {
    }

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param listOfNum Array of integers to be sorted
     */
    public static void bubbleSort(final int[] listOfNum) {
        // Get the length of the integer array
        final int n = listOfNum.length;
        // Loop through the array from the start
        for (int i = 0; i < n - 1; i++) {
            // Create a boolean variable to track if a swap occurred
            boolean swapped = false;
            // Loop through the unsorted portion of the array
            for (int j = 0; j < n - i - 1; j++) {
                // Check if the current number is bigger than the next number
                if (listOfNum[j] > listOfNum[j + 1]) {
                    // Temporarily store the current number
                    final int temp = listOfNum[j];
                    // Move the next number into the current position
                    listOfNum[j] = listOfNum[j + 1];
                    // Move the temporary number into the next position
                    listOfNum[j + 1] = temp;
                    // Mark that a swap has happened
                    swapped = true;
                }
            }
            // Check if no swaps happened in the inner loop
            if (!swapped) {
                // Stop the loop early because the array is sorted
                break;
            }
        }
    }

    /**
     * Main method to execute file reading and sorting.
     *
     * @param args Command line arguments
     * @throws FileNotFoundException If an input file is not found
     */
    public static void main(final String[] args) throws FileNotFoundException {
        // Create a Scanner object to read the input text file
        final Scanner scanner = new Scanner(new File("input.txt"));
        // Create a PrintWriter object to write to the output text file
        final PrintWriter writer = new PrintWriter(new File("output.txt"));

        // Loop through the file as long as there is another line of text
        while (scanner.hasNextLine()) {
            // Read the entire line of text into a String variable
            final String line = scanner.nextLine();
            // Split the line by spaces and put the strings into an array
            final String[] stringNumbers = line.split(" ");
            // Create a new integer array with the same size as the string array
            final int[] numbers = new int[stringNumbers.length];
            // Loop through every item in the string array
            for (int i = 0; i < stringNumbers.length; i++) {
                // Convert the string into an integer and save it in the array
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }

            // Pass the integer array to the bubbleSort method to be sorted
            bubbleSort(numbers);

            // Loop through the newly sorted integer array
            for (int i = 0; i < numbers.length; i++) {
                // Write the number to the output file
                writer.print(numbers[i]);
                // Check if the current number is NOT the last one in the array
                if (i < numbers.length - 1) {
                    // Write a space after the number
                    writer.print(" ");
                }
            }
            // Move to the next line in the output file
            writer.println();
        }

        // Close the scanner so it stops reading the file
        scanner.close();
        // Close the writer so it saves the file properly
        writer.close();
        // Print a message to the console showing it finished
        System.out.println("Sorting done. ");
    }
}
