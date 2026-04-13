import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;
    private String[] consist;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        consist = new String[]{"BG101", "BG205", "BG309", "BG412", "BG550"};
    }

    @Test
    void testSearch_BogieFound() {
        // Searching for an existing middle element
        assertTrue(app.searchBogieById(consist, "BG309"), "Should return true for existing ID 'BG309'");
    }

    @Test
    void testSearch_BogieNotFound() {
        // Searching for a non-existent ID
        assertFalse(app.searchBogieById(consist, "BG999"), "Should return false for non-existent ID 'BG999'");
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifying match at index 0
        assertTrue(app.searchBogieById(consist, "BG101"), "Search should succeed at the first position.");
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifying match at the final index
        assertTrue(app.searchBogieById(consist, "BG550"), "Search should succeed at the last position.");
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifying search logic with only one item
        String[] singleConsist = {"BG101"};
        assertTrue(app.searchBogieById(singleConsist, "BG101"), "Search should work for single element arrays.");
    }
}
