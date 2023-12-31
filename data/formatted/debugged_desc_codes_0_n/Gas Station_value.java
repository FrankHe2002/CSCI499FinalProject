```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int totalCost = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            totalFuel += gas[i];
            totalCost += cost[i];
        }
        if (totalFuel < totalCost) {
            return -1;
        }

        int start = 0;
        int currFuel = 0;
        for (int i = 0; i < n; i++) {
            currFuel += (gas[i] - cost[i]);
            if (currFuel < 0) {
                start = i + 1;
                currFuel = 0;
            }
        }
        if (start == n) { //start can be equal to n which gives index out of range
            return -1;
        }
        return start;
    }
}
```