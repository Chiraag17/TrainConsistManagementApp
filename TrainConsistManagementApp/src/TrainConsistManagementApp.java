import java.util.LinkedList;
import java.util.List;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 4: Maintain Ordered Bogie Consist
 * Description: Models the physical chaining of train bogies using LinkedList.
 * Author: Developer
 * Version: 4.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC4 Maintain Ordered Bogie Consist ");
        System.out.println(" ------------------------------------\n");

        // 1. Create a LinkedList to hold the train consist
        // LinkedList is ideal for modeling a train as it allows efficient
        // insertions and deletions at any position.
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. ADD bogies in sequence (Create the initial chain)
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");
        trainConsist.add("Guard Coach");

        System.out.println("Initial Train Formation: " + trainConsist);

        // 3. INSERT a bogie at a specific position (e.g., Pantry Car at index 2)
        System.out.println("\nInserting 'Pantry Car' at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("Updated Formation: " + trainConsist);

        // 4. REMOVE bogies from front and rear
        System.out.println("\nDetaching the first and last bogies...");
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard Coach

        // 5. Display updated train structure
        System.out.println("Final Ordered Train Consist: " + trainConsist);
        System.out.println("Current Bogie Count: " + trainConsist.size());
        System.out.println("------------------------------------");

        System.out.println("Physical chaining logic validated using LinkedList nodes.");
    }
}
