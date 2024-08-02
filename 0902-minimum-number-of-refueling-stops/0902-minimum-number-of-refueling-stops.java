import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-heap to store the fuel amounts of the reachable stations
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        // Initialize variables
        int currentFuel = startFuel;
        int refuelStops = 0;
        int index = 0;
        int n = stations.length;
        
        // Add a dummy station at the target with zero fuel
        stations = addDummyStation(stations, target);
        
        // Traverse through the stations
        for (int[] station : stations) {
            int distanceToStation = station[0];
            int fuelAtStation = station[1];
            
            // Refuel until you can reach the current station
            while (currentFuel < distanceToStation) {
                if (maxHeap.isEmpty()) {
                    return -1; // Impossible to reach the target
                }
                currentFuel += maxHeap.poll(); // Refuel with the maximum available fuel
                refuelStops++;
            }
            
            // Add the current station's fuel to the heap
            maxHeap.offer(fuelAtStation);
        }
        
        return refuelStops;
    }
    
    // Helper method to add a dummy station at the target
    private int[][] addDummyStation(int[][] stations, int target) {
        int[][] extendedStations = new int[stations.length + 1][2];
        System.arraycopy(stations, 0, extendedStations, 0, stations.length);
        extendedStations[stations.length] = new int[]{target, 0};
        return extendedStations;
    }
}
