import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 * Description: Enforces data integrity by validating input formats using Regular Expressions.
 * Author: Developer
 * Version: 11.0
 */
public class TrainConsistManagementApp {

    // Regex Patterns as per business rules
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    /**
     * Validates if the Train ID matches the format TRN-XXXX (4 digits)
     */
    public boolean isValidTrainID(String trainID) {
        if (trainID == null) return false;
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    /**
     * Validates if the Cargo Code matches the format PET-XX (2 uppercase letters)
     */
    public boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC11 Validate Train ID & Cargo Codes ");
        System.out.println(" ===================================\n");

        // Example Inputs
        String testTrainID = "TRN-1234";
        String testCargoCode = "PET-AB";

        System.out.println("Checking Train ID: " + testTrainID + " -> " +
                (app.isValidTrainID(testTrainID) ? "VALID" : "INVALID"));

        System.out.println("Checking Cargo Code: " + testCargoCode + " -> " +
                (app.isValidCargoCode(testCargoCode) ? "VALID" : "INVALID"));

        // Invalid Examples
        System.out.println("\nTesting Invalid Formats:");
        System.out.println("Train ID 'TRN-12A': " + app.isValidTrainID("TRN-12A"));
        System.out.println("Cargo Code 'PET-ab': " + app.isValidCargoCode("PET-ab"));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Input integrity verified using Regex.");
    }
}
