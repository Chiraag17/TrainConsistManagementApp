import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Rectangular", "Coal"));

        assertTrue(app.checkSafetyCompliance(list), "Train should be safe when Cylindrical carries Petroleum.");
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Coal")); // VIOLATION

        assertFalse(app.checkSafetyCompliance(list), "Cylindrical bogie carrying Coal must fail safety check.");
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Open", "Grain"));
        list.add(new GoodsBogie("Box", "Electronics"));

        assertTrue(app.checkSafetyCompliance(list), "Non-cylindrical bogies should allow any cargo.");
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum")); // Valid
        list.add(new GoodsBogie("Cylindrical", "Water"));     // Invalid (based on rule)

        assertFalse(app.checkSafetyCompliance(list), "One violation should make the entire train unsafe.");
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> emptyList = new ArrayList<>();
        assertTrue(app.checkSafetyCompliance(emptyList), "An empty train is technically compliant (no hazards).");
    }
}
