import java.util.Arrays;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * Description: Utilizes Java's optimized built-in sorting utility for alphabetical ordering.
 * Author: Developer
 * Version: 17.0
 */
public class TrainConsistManagementApp {

    /**
     * Sorts an array of bogie names alphabetically using the standard library.
     * Time Complexity: O(n log n)
     */
    public String[] sortBogieNames(String[] names) {
        if (names != null) {
            Arrays.sort(names);
        }
        return names;
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC17 Sort Bogie Names (Arrays.sort) ");
        System.out.println(" ===================================\n");

        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Unsorted Bogie Types: " + Arrays.toString(bogieTypes));

        // Using built-in optimized sorting
        app.sortBogieNames(bogieTypes);

        System.out.println("Alphabetically Sorted: " + Arrays.toString(bogieTypes));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Sorting optimized using Java Arrays utility.");
    }
}
