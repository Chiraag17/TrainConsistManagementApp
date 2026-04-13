import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Should not throw any exception
        assertDoesNotThrow(() -> {
            new Bogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verify negative value triggers the custom exception
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verify zero triggers the custom exception
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC Chair", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Cargo", -5);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        // Verify fields are stored correctly after successful validation
        Bogie bogie = new Bogie("First Class", 24);
        assertEquals("First Class", bogie.getType());
        assertEquals(24, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new Bogie("Sleeper", 72);
            new Bogie("General", 90);
            new Bogie("AC Chair", 56);
        });
    }
}
