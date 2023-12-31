```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Map<String, List<int[]>> adj = new HashMap<>();
        boolean[][] visited = new boolean[rows][cols];
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                List<int[]> list = new ArrayList<>();
                for (int[] direction : directions) {
                    int newRow = direction[0] + i;
                    int newCol = direction[1] + j;
                    boolean isInBoard = newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols;
                    if (isInBoard) {
                        list.add(new int[] {newRow, newCol, grid[newRow][newCol]});
                    }
                }
                adj.put(getNodeStringFormat(i, j, grid[i][j]), list);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                if (visited[i][j]) {
                    continue;
                }
                queue.add(getNodeStringFormat(i, j, grid[i][j]));
                while (!queue.isEmpty()) {
                    String currentStr = queue.poll();
                    String[] current = currentStr.split(",");
                    int row = Integer.valueOf(current[0]);
                    int col = Integer.valueOf(current[1]);
                    int island = Integer.valueOf(current[2]);
                    if (!adj.containsKey(currentStr) || visited[row][col]) {
                        continue;
                    }
                    if (island == 1) {
                        count++;
                    }
                    visited[row][col] = true;
                    for (int[] item : adj.get(currentStr)) {
                        int newRow = item[0];
                        int newCol = item[1];
                        int newIsland = item[2];
                        if (!visited[newRow][newCol] && newIsland == 1 && island == 1) {
                            queue.add(getNodeStringFormat(newRow, newCol, newIsland