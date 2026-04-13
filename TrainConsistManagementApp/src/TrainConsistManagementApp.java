import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
 * Use Case 8: Filter Passenger Bogies Using Streams
 * Description: Uses Java Stream API to filter bogies based on a capacity threshold.
 * Author: Developer
 * Version: 8.0
 */
public class TrainConsistManagementApp {

    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        // Stream API: Filter bogies where capacity > threshold
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC8 Filter Passenger Bogies (Streams) ");
        System.out.println(" ===================================\n");

        List<Bogie> trainFormation = new ArrayList<>();
        trainFormation.add(new Bogie("Sleeper", 72));
        trainFormation.add(new Bogie("AC Chair", 56));
        trainFormation.add(new Bogie("First Class", 24));
        trainFormation.add(new Bogie("General", 90));

        System.out.println("All Available Bogies:");
        trainFormation.forEach(System.out::println);

        // Applying filter logic: Capacity > 60
        int threshold = 60;
        List<Bogie> highCapacityBogies = app.filterHighCapacityBogies(trainFormation, threshold);

        System.out.println("\nFiltered Bogies (Capacity > " + threshold + "):");
        highCapacityBogies.forEach(System.out::println);

        System.out.println("\n------------------------------------");
        System.out.println("Success: High-capacity bogies identified using Streams.");
    }
}
