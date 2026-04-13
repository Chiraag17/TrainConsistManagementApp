/**
 * MAIN CLASS: TrainConsistManagementApp
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 * Description: Implements a manual sorting algorithm to understand internal data organization.
 * Author: Developer
 * Version: 16.0
 */
public class TrainConsistManagementApp {

    /**
     * Manual implementation of Bubble Sort Algorithm.
     * Compares adjacent elements and swaps them to arrange in ascending order.
     */
    public int[] bubbleSort(int[] capacities) {
        int n = capacities.length;
        // Outer loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for adjacent comparison
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
        return capacities;
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("------------------------------------");
        System.out.println(" UC16 Sort Bogies (Bubble Sort)     ");
        System.out.println(" ===================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Unsorted Capacities: ");
        printArray(capacities);

        // Sorting manually without library methods
        app.bubbleSort(capacities);

        System.out.print("Sorted Capacities (Manual Sort): ");
        printArray(capacities);

        System.out.println("\n------------------------------------");
        System.out.println("Success: Sorting logic implemented using Bubble Sort.");
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
