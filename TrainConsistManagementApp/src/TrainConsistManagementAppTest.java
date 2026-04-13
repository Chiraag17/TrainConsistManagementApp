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
        for (int i = 0; i < 100; i++) {
            testList.add(new Bogie("Bogie", i)); // Capacity 0 to 99
        }
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = app.filterWithLoop(testList, 60);
        // Expect 39 bogies (61 to 99)
        assertEquals(39, result.size(), "Loop should filter bogies > 60.");
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = app.filterWithStream(testList, 60);
        assertEquals(39, result.size(), "Stream should filter bogies > 60.");
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopRes = app.filterWithLoop(testList, 50);
        List<Bogie> streamRes = app.filterWithStream(testList, 50);
        assertEquals(loopRes.size(), streamRes.size(), "Both methods should return identical result counts.");
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        app.filterWithLoop(testList, 50);
        long end = System.nanoTime();
        assertTrue((end - start) > 0, "Elapsed time should be a positive value.");
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> hugeList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) hugeList.add(new Bogie("B", 70));

        List<Bogie> result = app.filterWithStream(hugeList, 60);
        assertEquals(50000, result.size(), "Should process large datasets accurately.");
    }
}
