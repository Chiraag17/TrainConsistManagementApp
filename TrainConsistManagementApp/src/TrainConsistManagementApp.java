import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * BOGIE CLASS: Data Model
 * Represents a physical bogie with attributes for name and capacity.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("%-15s | Capacity: %d", name, capacity);
    }
}

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * Description: Uses custom objects and Comparator to rank bogies by their capacity.
 * Author: Developer
 * Version: 7.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC7 Sort Bogies by Capacity (Comparator) ");
        System.out.println(" ===================================\n");

        // 1. Create a List of Bogie objects
        List<Bogie> passengerBogies = new ArrayList<>();

        // 2. Add passenger bogies with their capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Unsorted Passenger Bogies:");
        passengerBogies.forEach(System.out::println);

        // 3. Apply Comparator to sort by capacity (Ascending)
        // Key Concept: Comparator.comparingInt defines the business logic for sorting
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // 4. Display Sorted Bogies
        System.out.println("\nPassenger Bogies Sorted by Capacity (Low to High):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // 5. Summary
        System.out.println("\n------------------------------------");
        System.out.println("Success: Bogies ranked for optimal capacity planning.");
    }
}
