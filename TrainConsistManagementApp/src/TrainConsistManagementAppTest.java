import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;
    private List<Bogie> testList;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        testList = new ArrayList<>();
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("Sleeper", 72));
        testList.add(new Bogie("AC Chair", 56));
        testList.add(new Bogie("First Class", 24));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result = app.groupBogiesByType(testList);
        // Verify keys exist
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result = app.groupBogiesByType(testList);
        // Verify Sleeper group has 2 bogies
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        Map<String, List<Bogie>> result = app.groupBogiesByType(emptyList);
        assertTrue(result.isEmpty(), "Resulting map should be empty");
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result = app.groupBogiesByType(testList);
        assertEquals(3, result.keySet().size(), "There should be exactly 3 distinct categories");
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        int originalSize = testList.size();
        app.groupBogiesByType(testList);
        assertEquals(originalSize, testList.size(), "Grouping should not modify the original list");
    }
}
