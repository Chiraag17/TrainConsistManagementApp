/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 18: Linear Search for Bogie ID (Array-Based Searching)
 * Description: Implements a sequential search to locate a specific bogie ID in an unsorted array.
 * Author: Developer
 * Version: 18.0
 */
public class TrainConsistManagementApp {

    /**
     * Performs a Linear Search on an array of bogie IDs.
     * Time Complexity: O(n)
     * @param bogieIds Array of bogie IDs to search through
     * @param searchKey The bogie ID to find
     * @return true if the ID exists in the array, false otherwise
     */
    public boolean searchBogieById(String[] bogieIds, String searchKey) {
        if (bogieIds == null || searchKey == null) {
            return false;
        }

        // Sequential Traversal
        for (String id : bogieIds) {
            // Equality Comparison using equals() for Strings
            if (id.equals(searchKey)) {
                return true; // Early Termination upon match
            }
        }
        return false; // Match not found after full traversal
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC18 Linear Search for Bogie ID    ");
        System.out.println(" ===================================\n");

        String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Available Bogie IDs: " + java.util.Arrays.toString(consist));
        System.out.println("Searching for Bogie ID: " + searchKey);

        boolean found = app.searchBogieById(consist, searchKey);

        if (found) {
            System.out.println("Result: Bogie " + searchKey + " identified in the consist.");
        } else {
            System.out.println("Result: Bogie " + searchKey + " not found.");
        }

        // Test case for not found
        System.out.println("\nSearching for Bogie ID: BG999");
        System.out.println("Result: Found? " + app.searchBogieById(consist, "BG999"));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Search operation performed via Sequential Traversal.");
    }
}
