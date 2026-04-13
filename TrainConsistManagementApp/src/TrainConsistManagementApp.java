import java.util.HashMap;
import java.util.Map;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 6: Map Bogie to Capacity
 * Description: Associates each bogie type with its specific seating or load capacity using HashMap.
 * Author: Developer
 * Version: 6.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC6 Map Bogie to Capacity (HashMap) ");
        System.out.println(" ===================================\n");

        // 1. Initialize HashMap
        // Key: Bogie Name (String), Value: Capacity (Integer)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // 2. Map bogies to their respective capacities (put method)
        System.out.println("Mapping bogie types to operational capacities...");
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo-Rectangular", 1000); // capacity in kg/units
        bogieCapacityMap.put("Cylindrical-Tanker", 500);

        // 3. Fast Lookup Example
        // HashMap allows O(1) time complexity to retrieve a value using its key
        String searchBogie = "Sleeper";
        if (bogieCapacityMap.containsKey(searchBogie)) {
            System.out.println("Lookup: " + searchBogie + " has a capacity of " + bogieCapacityMap.get(searchBogie) + " units.");
        }

        // 4. Iterate through the map using entrySet()
        // This allows us to access both the Bogie Name (Key) and Capacity (Value)
        System.out.println("\n--- Current Bogie Capacity Directory ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        // 5. Summary
        System.out.println("\nTotal bogie types mapped: " + bogieCapacityMap.size());
        System.out.println("------------------------------------");
        System.out.println("Success: Key-Value association established for operational analytics.");
    }
}
