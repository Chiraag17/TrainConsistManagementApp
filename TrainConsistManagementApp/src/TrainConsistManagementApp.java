import java.util.ArrayList;
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
 * Use Case 10: Count Total Seats in Train (reduce)
 * Description: Uses map-reduce pattern to aggregate individual capacities into a total sum.
 * Author: Developer
 * Version: 10.0
 */
public class TrainConsistManagementApp {

    // Method to calculate total capacity using Stream reduce
    public int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)        // Step 1: Extract numeric capacity
                .reduce(0, Integer::sum);       // Step 2: Sum the values starting from 0
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC10 Count Total Seats (reduce)    ");
        System.out.println(" ===================================\n");

        List<Bogie> trainFormation = new ArrayList<>();
        trainFormation.add(new Bogie("Sleeper", 72));
        trainFormation.add(new Bogie("AC Chair", 56));
        trainFormation.add(new Bogie("First Class", 24));
        trainFormation.add(new Bogie("General", 90));

        System.out.println("Current Train Formation:");
        trainFormation.forEach(System.out::println);

        // Calculate Total
        int totalSeats = app.calculateTotalCapacity(trainFormation);

        System.out.println("\n--- Total Capacity Analysis ---");
        System.out.println("Total Seating Capacity: " + totalSeats + " seats");

        System.out.println("\n------------------------------------");
        System.out.println("Success: Total metrics aggregated for operational planning.");
    }
}
