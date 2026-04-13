import java.util.Arrays;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 20: Exception Handling During Search Operations
 * Description: Implements defensive programming to prevent searches on empty train formations.
 * Author: Developer
 * Version: 20.0
 */
public class TrainConsistManagementApp {

    /**
     * Searches for a bogie ID with state validation.
     * @throws IllegalStateException if the consist is empty.
     */
    public boolean searchWithValidation(String[] bogieIds, String searchKey) {
        // 1. State Validation (Fail-Fast)
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search Failed: No bogies available in the train consist.");
        }

        // 2. Perform Search (Linear Search for simplicity)
        for (String id : bogieIds) {
            if (id != null && id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC20 Exception Handling in Search  ");
        System.out.println(" ===================================\n");

        // Scenario 1: Searching with Data
        String[] activeConsist = {"BG101", "BG205", "BG309"};
        System.out.println("Scenario 1: Searching in active consist " + Arrays.toString(activeConsist));
        try {
            boolean found = app.searchWithValidation(activeConsist, "BG205");
            System.out.println("Result: Bogie found? " + found);
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }

        // Scenario 2: Searching an Empty Consist
        String[] emptyConsist = {};
        System.out.println("\nScenario 2: Searching in empty consist {}");
        try {
            app.searchWithValidation(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\n------------------------------------");
        System.out.println("Success: Defensive search logic verified.");
    }
}
