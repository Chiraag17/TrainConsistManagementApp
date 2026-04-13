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
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input), "Bogie names should be sorted alphabetically.");
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        assertArrayEquals(expected, app.sortBogieNames(input), "Already sorted array should remain unchanged.");
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input), "Duplicates should be retained and positioned correctly.");
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        assertArrayEquals(expected, app.sortBogieNames(input));
    }
}
