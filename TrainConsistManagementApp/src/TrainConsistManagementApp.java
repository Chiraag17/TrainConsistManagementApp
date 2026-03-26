import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 2: Add Passenger Bogies to Train
 * Description: Demonstrates dynamic management of passenger bogies using ArrayList.
 * Author: Developer
 * Version: 2.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Display Header
        System.out.println("---------------*************");
        System.out.println(" UC2 Add Passenger Bogies to Train ");
        System.out.println("---------------*********\n");

        // 1. CREATE: Initialize an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. ADD: Attach new bogies to the train (Sleeper, AC Chair, First Class)
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. READ: Display the current consist after additions
        System.out.println("Current Train Consist: " + passengerBogies);
        System.out.println("Initial Bogie Count: " + passengerBogies.size());

        // 4. DELETE: Remove one bogie (e.g., AC Chair)
        System.out.println("\nRemoving 'AC Chair' from the consist...");
        passengerBogies.remove("AC Chair");

        // 5. CHECK: Use contains() to check if 'Sleeper' exists
        String checkBogie = "Sleeper";
        if (passengerBogies.contains(checkBogie)) {
            System.out.println("Status: " + checkBogie + " Bogie exists in the train.");
        } else {
            System.out.println("Status: " + checkBogie + " Bogie not found.");
        }

        // 6. FINAL STATE: Display the final consist summary
        System.out.println("\nFinal Train Consist Summary:");
        System.out.println(passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
        System.out.println("----------------------------------------------");
    }
}
