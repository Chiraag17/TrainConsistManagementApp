import java.util.Arrays;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 19: Binary Search for Bogie ID (Optimized Searching)
 * Description: Implements a divide-and-conquer strategy to locate bogies efficiently.
 * Author: Developer
 * Version: 19.0
 */
public class TrainConsistManagementApp {

    /**
     * Performs a Binary Search on an array of bogie IDs.
     * Precondition: The array must be sorted.
     * Time Complexity: O(log n)
     */
    public boolean binarySearchBogie(String[] bogieIds, String searchKey) {
        if (bogieIds == null || bogieIds.length == 0 || searchKey == null) {
            return false;
        }

        // Ensuring the data is sorted (UC Requirement)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return false; // Exhausted search range
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC19 Binary Search for Bogie ID    ");
        System.out.println(" ===================================\n");

        // Unsorted input example (to demonstrate handling)
        String[] consist = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchKey = "BG309";

        System.out.println("Input IDs (Unsorted): " + Arrays.toString(consist));

        boolean found = app.binarySearchBogie(consist, searchKey);

        System.out.println("Sorted IDs for Search: " + Arrays.toString(consist));
        System.out.println("Searching for: " + searchKey);
        System.out.println("Result: " + (found ? "Bogie Found" : "Bogie Not Found"));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Optimized lookup via Divide-and-Conquer.");
    }
}
