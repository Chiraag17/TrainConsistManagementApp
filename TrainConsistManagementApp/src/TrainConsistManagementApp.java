import java.util.ArrayList;
import java.util.List;

/**
 * CUSTOM EXCEPTION: InvalidCapacityException
 * Represents a domain-specific error when bogie capacity is non-positive.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * BOGIE CLASS: Data Model
 * Enforces business rules during object construction.
 */
class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return "Bogie Type: " + type + " | Capacity: " + capacity;
    }
}

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * Description: Prevents invalid bogie creation using fail-fast validation.
 * Author: Developer
 * Version: 14.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println(" UC14 Handle Invalid Bogie Capacity ");
        System.out.println(" ===================================\n");

        List<Bogie> trainConsist = new ArrayList<>();

        try {
            System.out.println("Attempting to add valid bogie...");
            trainConsist.add(new Bogie("Sleeper", 72));
            System.out.println("Success: Sleeper bogie added.");

            System.out.println("\nAttempting to add invalid bogie (Zero Capacity)...");
            trainConsist.add(new Bogie("AC Chair", 0));

        } catch (InvalidCapacityException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to add invalid bogie (Negative Capacity)...");
            trainConsist.add(new Bogie("First Class", -10));

        } catch (InvalidCapacityException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }

        System.out.println("\nFinal Train Consist Size: " + trainConsist.size());
        System.out.println("------------------------------------");
        System.out.println("Success: Integrity maintained via Custom Exceptions.");
    }
}
