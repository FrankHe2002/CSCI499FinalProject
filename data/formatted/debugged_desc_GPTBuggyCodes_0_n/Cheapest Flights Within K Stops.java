```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        Map<Integer, List<int[]>> flightsMap = new HashMap<>();
        for (int[] flight : flights) {
            int flightSrc = flight[0];
            int flightDst = flight[1];
            int flightPrice = flight[2];

            List<int[]> flightsList = flightsMap.getOrDefault(flightSrc, new ArrayList<>());
            flightsList.add(new int[] {flightDst, flightPrice});
            flightsMap.put(flightSrc, flightsList);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (k >= 0 && !q.isEmpty()) {
            int[] tempPrices = prices.clone();

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curSrc = q.poll();
                int curPrice = prices[curSrc];
                List<int[]> curFlightsList = flightsMap.getOrDefault(curSrc, new ArrayList<>());
                for (int[] flight : curFlightsList) {
                    int flightDst = flight[0];
                    int flightPrice = flight[1];
                    int newPrice = curPrice + flightPrice;
                    if (newPrice < tempPrices[flightDst]) {
                        tempPrices[flightDst] = newPrice;
                        q.offer(flightDst);
                    }
                }
            }
            for (int i = 0; i < n; i++)
                prices[i] = tempPrices[i];
            k--;
        }
        int totalPrice = prices[dst];
        return totalPrice == Integer.MAX_VALUE ? -1 : totalPrice;
    }
}
```