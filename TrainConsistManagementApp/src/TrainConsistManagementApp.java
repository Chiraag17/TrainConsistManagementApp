import java.util.LinkedHashSet;
import java.util.Set;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 5: Preserve Insertion Order of Bogies
 * Description: Maintains the exact attachment order while preventing duplicate entries using LinkedHashSet.
 * Author: Developer
 * Version: 5.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC5 Preserve Insertion Order of Bogies ");
        System.out.println(" ===================================\n");

        // 1. Initialize LinkedHashSet
        // LinkedHashSet combines the uniqueness of HashSet with the ordering of LinkedList
        Set<String> formation = new LinkedHashSet<>();

        // 2. Attach bogies in sequence (Add bogies)
        System.out.println("Attaching bogies to the engine...");
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 3. Attempt to attach a duplicate bogie (Automatic Deduplication)
        // Business Rule: The same physical bogie cannot be attached twice.
        System.out.println("Attempting to re-attach 'Sleeper' bogie...");
        boolean isAdded = formation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Validation: Duplicate bogie 'Sleeper' rejected.");
        }

        // 4. Display final train formation
        // Notice that the order is preserved exactly as they were first added
        System.out.println("\nFinal Train Formation (Ordered & Unique):");
        System.out.println(formation);

        // 5. Summary
        System.out.println("\nTotal unique bogies in formation: " + formation.size());
        System.out.println("------------------------------------");
        System.out.println("Success: Formation order preserved and duplicates prevented.");
    }
}
