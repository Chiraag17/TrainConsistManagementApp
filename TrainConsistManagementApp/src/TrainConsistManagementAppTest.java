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
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, app.bubbleSort(input), "Array should be sorted in ascending order.");
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, app.bubbleSort(input), "Already sorted array should remain unchanged.");
    }

    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        assertArrayEquals(expected, app.bubbleSort(input), "Sorting should handle duplicate capacities correctly.");
    }

    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        assertArrayEquals(expected, app.bubbleSort(input), "Single element array should remain unchanged.");
    }

    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        assertArrayEquals(expected, app.bubbleSort(input), "Array with identical values should remain unchanged.");
    }
}
