import java.util.ArrayList;
import java.util.List;

/**
 * GOODS BOGIE CLASS: Data Model
 * Represents a goods bogie with its shape and assigned cargo.
 */
class GoodsBogie {
    private String type; // e.g., "Cylindrical", "Rectangular"
    private String cargo; // e.g., "Petroleum", "Coal"

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("Type: %-12s | Cargo: %-10s", type, cargo);
    }
}

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * Description: Uses Stream.allMatch() to enforce domain-specific cargo safety rules.
 * Author: Developer
 * Version: 12.0
 */
public class TrainConsistManagementApp {

    /**
     * Business Rule: Cylindrical bogies MUST only carry Petroleum.
     * All other bogie types can carry any cargo.
     */
    public boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are always compliant in this UC
        });
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC12 Safety Compliance Check       ");
        System.out.println(" ===================================\n");

        List<GoodsBogie> goodsFormation = new ArrayList<>();
        goodsFormation.add(new GoodsBogie("Rectangular", "Coal"));
        goodsFormation.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsFormation.add(new GoodsBogie("Open", "Iron Ore"));

        System.out.println("Inspecting Goods Formation:");
        goodsFormation.forEach(System.out::println);

        boolean isSafe = app.checkSafetyCompliance(goodsFormation);

        System.out.println("\nSafety Status: " + (isSafe ? "✅ COMPLIANT" : "❌ HAZARD DETECTED"));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Safety rules enforced via Stream validation.");
    }
}
