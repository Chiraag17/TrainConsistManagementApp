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
    void testCargo_SafeAssignment() {
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        // Should not throw exception
        assertDoesNotThrow(() -> cylindrical.assignCargo("Petroleum"));
        assertEquals("Petroleum", cylindrical.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        // Verify CargoSafetyException is raised
        assertThrows(CargoSafetyException.class, () -> {
            rectangular.assignCargo("Petroleum");
        }, "Petroleum in Rectangular bogie must trigger safety exception.");
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        try {
            rectangular.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Expected catch
        }
        // Verify cargo remains "Empty" and not "Petroleum"
        assertNotEquals("Petroleum", rectangular.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie rect = new GoodsBogie("Rectangular");
        GoodsBogie cyl = new GoodsBogie("Cylindrical");

        app.processCargoAssignment(rect, "Petroleum"); // Throws and catches
        app.processCargoAssignment(cyl, "Petroleum");  // Should still execute

        assertEquals("Petroleum", cyl.getCargo(), "Program should continue to process next assignment.");
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // The finally block logic is verified via console output in the main app,
        // but ensure the logic does not interfere with valid assignments.
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        assertDoesNotThrow(() -> app.processCargoAssignment(bogie, "Coal"));
    }
}
