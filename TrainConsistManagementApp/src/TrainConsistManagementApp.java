import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BOGIE CLASS: Data Model
 * Represents a physical bogie with attributes for name and capacity.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * Description: Benchmarks execution time between imperative loops and declarative streams.
 * Author: Developer
 * Version: 13.0
 */
public class TrainConsistManagementApp {

    // Method using Traditional Loop
    public List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    // Method using Java Streams
    public List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();
        List<Bogie> largeTrain = new ArrayList<>();

        // 1. Prepare Large Dataset
        for (int i = 0; i < 10000; i++) {
            largeTrain.add(new Bogie("Bogie-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("------------------------------------");
        System.out.println(" UC13 Performance Comparison (Loops vs Streams) ");
        System.out.println(" ===================================\n");

        // 2. Measure Loop Performance
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopResult = app.filterWithLoop(largeTrain, 60);
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 3. Measure Stream Performance
        long startTimeStream = System.nanoTime();
        List<Bogie> streamResult = app.filterWithStream(largeTrain, 60);
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // 4. Display Results
        System.out.println("Loop Filter Time   : " + durationLoop + " ns");
        System.out.println("Stream Filter Time : " + durationStream + " ns");
        System.out.println("Results Match      : " + (loopResult.size() == streamResult.size()));

        System.out.println("\n------------------------------------");
        System.out.println("Success: Benchmarking completed with System.nanoTime().");
    }
}
