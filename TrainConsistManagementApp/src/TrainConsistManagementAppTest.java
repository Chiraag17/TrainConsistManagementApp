import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;
    private List<Bogie> testList;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        // 72 + 56 + 24 = 152
        int total = app.calculateTotalCapacity(testList);
        assertEquals(152, total, "Total capacity should be the sum of all bogies");
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> singleList = new ArrayList<>();
        singleList.add(new Bogie("General", 90));
        int total = app.calculateTotalCapacity(singleList);
        assertEquals(90, total, "Total should equal the capacity of the single bogie");
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        int total = app.calculateTotalCapacity(emptyList);
        assertEquals(0, total, "Empty train should have 0 seating capacity");
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = app.calculateTotalCapacity(testList);
        // If we add one more, the count should increase exactly by that amount
        testList.add(new Bogie("Extra", 10));
        assertEquals(total + 10, app.calculateTotalCapacity(testList));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        int originalSize = testList.size();
        app.calculateTotalCapacity(testList);
        assertEquals(originalSize, testList.size(), "Aggregation must not modify the original collection");
    }
}
