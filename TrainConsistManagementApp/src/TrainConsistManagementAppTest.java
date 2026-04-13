import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
    }

    @Test
    void testRegex_ValidTrainID() {
        // Input: TRN-1234 | Expected: true
        assertTrue(app.isValidTrainID("TRN-1234"), "Valid Train ID should be accepted.");
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Test various invalid formats
        assertFalse(app.isValidTrainID("TRAIN12"), "Missing prefix and hyphen.");
        assertFalse(app.isValidTrainID("TRN12A"), "Contains letters in numeric part.");
        assertFalse(app.isValidTrainID("1234-TRN"), "Reverse order should fail.");
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Must be exactly 4 digits
        assertFalse(app.isValidTrainID("TRN-123"), "Too few digits.");
        assertFalse(app.isValidTrainID("TRN-12345"), "Too many digits.");
    }

    @Test
    void testRegex_ValidCargoCode() {
        // Input: PET-AB | Expected: true
        assertTrue(app.isValidCargoCode("PET-AB"), "Valid Cargo Code should be accepted.");
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(app.isValidCargoCode("PET123"), "Numeric suffix rejected.");
        assertFalse(app.isValidCargoCode("AB-PET"), "Incorrect structure.");
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Case sensitivity check
        assertFalse(app.isValidCargoCode("PET-ab"), "Lowercase suffix should be rejected.");
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(app.isValidTrainID(""), "Empty Train ID is invalid.");
        assertFalse(app.isValidCargoCode(""), "Empty Cargo Code is invalid.");
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // matches() checks the whole string
        assertFalse(app.isValidTrainID("TRN-1234extra"), "Trailing characters should cause failure.");
    }
}
