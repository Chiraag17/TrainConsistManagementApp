import java.util.ArrayList;
import java.util.List;

/**
 * CUSTOM RUNTIME EXCEPTION: CargoSafetyException
 * Represents a safety violation during dynamic cargo assignment.
 */
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

/**
 * GOODS BOGIE CLASS: Data Model
 * Handles safe cargo assignment with compatibility logic.
 */
class GoodsBogie {
    private String shape;
    private String cargo = "Empty";

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoName) {
        // Business Rule: Petroleum is unsafe for Rectangular bogies
        if (this.shape.equalsIgnoreCase("Rectangular") && cargoName.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("HAZARD: Petroleum cannot be assigned to Rectangular bogie!");
        }
        this.cargo = cargoName;
    }

    public String getShape() { return shape; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return "Bogie Shape: " + shape + " | Cargo: " + cargo;
    }
}

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * Description: Implements structured error handling for dynamic operational safety.
 * Author: Developer
 * Version: 15.0
 */
public class TrainConsistManagementApp {

    public void processCargoAssignment(GoodsBogie bogie, String cargo) {
        try {
            System.out.println("Processing: Assigning " + cargo + " to " + bogie.getShape() + " bogie...");
            bogie.assignCargo(cargo);
            System.out.println("Result: Assignment Successful.");
        } catch (CargoSafetyException e) {
            System.err.println("Safety Alert: " + e.getMessage());
        } finally {
            System.out.println("System: Safety check for assignment completed.");
        }
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC15 Safe Cargo Assignment (try-catch-finally) ");
        System.out.println(" ===================================\n");

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");

        // 1. Valid Assignment
        app.processCargoAssignment(cylindricalBogie, "Petroleum");

        System.out.println();

        // 2. Unsafe Assignment
        app.processCargoAssignment(rectangularBogie, "Petroleum");

        System.out.println("\nFinal Cargo Status:");
        System.out.println(cylindricalBogie);
        System.out.println(rectangularBogie);

        System.out.println("\n------------------------------------");
        System.out.println("Success: Safety rules enforced with structured handling.");
    }
}
