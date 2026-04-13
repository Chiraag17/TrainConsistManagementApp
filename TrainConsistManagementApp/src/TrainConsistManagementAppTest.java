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
    void testBinarySearch_BogieFound() {
        String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(app.binarySearchBogie(consist, "BG309"), "Should find existing ID 'BG309'");
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(app.binarySearchBogie(consist, "BG999"), "Should return false for non-existent ID.");
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] consist = {"BG101", "BG205", "BG309"};
        assertTrue(app.binarySearchBogie(consist, "BG101"), "Should find the first element.");
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] consist = {"BG101", "BG205", "BG309"};
        assertTrue(app.binarySearchBogie(consist, "BG309"), "Should find the last element.");
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] consist = {"BG101"};
        assertTrue(app.binarySearchBogie(consist, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] emptyConsist = {};
        assertFalse(app.binarySearchBogie(emptyConsist, "BG101"), "Empty array should return false.");
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Logic inside method ensures sorting before search
        String[] unsorted = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(app.binarySearchBogie(unsorted, "BG205"), "Should find 'BG205' even if input is initially unsorted.");
    }
}
