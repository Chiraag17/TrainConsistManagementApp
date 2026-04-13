import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainConsistManagementAppTest {

    private TrainConsistManagementApp app;
    private List<Bogie> testList;



    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
        testList.add(new Bogie("General", 90));
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
        testList.add(new Bogie("General", 90));
        List<Bogie> result = TrainConsistManagementApp.filterHighCapacityBogies(testList, 70);
        assertEquals(2, result.size(), "Should find 2 bogies (Sleeper, General)");
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
        testList.add(new Bogie("General", 90));
        // Threshold 72: Sleeper (72) should be EXCLUDED (condition is > 72)
        List<Bogie> result = TrainConsistManagementApp.filterHighCapacityBogies(testList, 72);
        assertEquals(1, result.size(), "Only General (90) should be included");
        assertNotEquals("Sleeper", result.get(0).getName());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
        testList.add(new Bogie("General", 90));
        List<Bogie> result = TrainConsistManagementApp.filterHighCapacityBogies(testList, 100);
        assertTrue(result.isEmpty(), "List should be empty for threshold 100");
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        List<Bogie> result = TrainConsistManagementApp.filterHighCapacityBogies(emptyList, 50);
        assertTrue(result.isEmpty(), "Filtering an empty list should return an empty list");
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
        testList.add(new Bogie("General", 90));
        int originalSize = testList.size();
        TrainConsistManagementApp.filterHighCapacityBogies(testList, 60);
        assertEquals(originalSize, testList.size(), "Original collection integrity must be maintained");
    }
}
