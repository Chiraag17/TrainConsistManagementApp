import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
 * Use Case 9: Group Bogies by Type (Collectors.groupingBy)
 * Description: Organizes a flat list of bogies into a categorized Map by bogie name.
 * Author: Developer
 * Version: 9.0
 */
public class TrainConsistManagementApp {

    // Method to group bogies by their name/type
    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC9 Group Bogies by Type (groupingBy) ");
        System.out.println(" ===================================\n");

        List<Bogie> trainFormation = new ArrayList<>();
        trainFormation.add(new Bogie("Sleeper", 72));
        trainFormation.add(new Bogie("AC Chair", 56));
        trainFormation.add(new Bogie("Sleeper", 72));
        trainFormation.add(new Bogie("First Class", 24));
        trainFormation.add(new Bogie("AC Chair", 56));

        System.out.println("Flat Train Formation List:");
        trainFormation.forEach(System.out::println);

        // Grouping logic
        Map<String, List<Bogie>> groupedBogies = app.groupBogiesByType(trainFormation);

        System.out.println("\nStructured Bogie Report (Grouped):");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " | Count: " + list.size());
            list.forEach(b -> System.out.println("  - " + b));
        });

        System.out.println("\n------------------------------------");
        System.out.println("Success: Bogies categorized for reporting.");
    }
}
