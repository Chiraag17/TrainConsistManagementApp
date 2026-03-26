import java.util.HashSet;
import java.util.Set;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 3: Track Unique Bogie IDs
 * Description: Ensures that duplicate bogie IDs are not added using HashSet.
 * Author: Developer
 * Version: 3.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC3 Track Unique Bogie IDs ");
        System.out.println(" ===================================\n");

        // 1. Create a Set to store unique bogie IDs
        // HashSet is used because it automatically prevents duplicate entries
        Set<String> bogieIds = new HashSet<>();

        // 2. ADD Bogie IDs (including intentional duplicates)
        // add() inserts bogie IDs into the set
        bogieIds.add("B0101");
        bogieIds.add("B0102");
        bogieIds.add("B0103");
        bogieIds.add("B0104");

        // 3. Attempting to add duplicate entries
        // These will be ignored internally by the HashSet implementation
        System.out.println("Attempting to add duplicate IDs: B0101, B0102...");
        bogieIds.add("B0101"); // Duplicate entry
        bogieIds.add("B0102"); // Duplicate entry

        // 4. Display Unique Bogie Identifiers
        // Notice that the output will only contain unique IDs
        System.out.println("\nFinal List of Unique Bogie IDs:");
        System.out.println(bogieIds);

        // 5. Display Total Count
        System.out.println("Total Unique Bogies tracked: " + bogieIds.size());
        System.out.println("------------------------------------");

        System.out.println("Business Rule Validated: No duplicate IDs allowed in the consist.");
    }
}
