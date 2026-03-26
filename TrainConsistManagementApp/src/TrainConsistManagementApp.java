import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 1: Initialize Train and Display Consist Summary
 * Author: Developer
 * Version: 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // 1. Print Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize an empty List to store bogies using ArrayList
        // We use the List interface for abstraction and ArrayList for dynamic resizing
        List<String> trainConsist = new ArrayList<>();

        // 3. Display Initial Bogie Count
        // Using the size() method to show the current state of the collection
        System.out.println("Initial Bogie Count: " + trainConsist.size());

        // 4. Print Current State
        System.out.println("Train consist initialized. Ready to add bogies.");
        System.out.println("==============================================");
    }
}
