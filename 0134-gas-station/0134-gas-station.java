class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            // If tank is negative, reset start point and tank
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        return totalGas >= totalCost ? start : -1;
    }
}
