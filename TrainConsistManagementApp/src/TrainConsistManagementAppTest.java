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
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyData = {};
        // Verifies that IllegalStateException is thrown
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.searchWithValidation(emptyData, "BG101");
        });
        assertEquals("Search Failed: No bogies available in the train consist.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] data = {"BG101", "BG205"};
        // Should not throw an exception
        assertDoesNotThrow(() -> app.searchWithValidation(data, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] data = {"BG101", "BG205", "BG309"};
        assertTrue(app.searchWithValidation(data, "BG205"), "Should return true for existing bogie.");
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] data = {"BG101", "BG205", "BG309"};
        assertFalse(app.searchWithValidation(data, "BG999"), "Should return false for non-existent bogie.");
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] data = {"BG101"};
        assertTrue(app.searchWithValidation(data, "BG101"), "Should work correctly with one bogie.");
    }
}
