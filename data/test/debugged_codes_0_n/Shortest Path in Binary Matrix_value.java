class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean [][] visited = new boolean [m][n];
        
        int [] up = {0, 0, 1, -1, 1, 1, -1, -1};
        int [] down = {-1, 1, 0, 0, -1, 1, -1, 1};
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        
        ArrayDeque<int []> q = new ArrayDeque<>();
        
        q.add(new int[]{0,0,1});        
        
        while(q.size() > 0){
            int [] tmp = q.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            int steps = tmp[2];
            visited[x][y] = true;
            
            if(x == m-1 && y == n-1)
                return steps;
            
            for(int i = 0; i < 8; i++){
                int x_new = x + up[i];
                int y_new = y + down[i];
                
                if(x_new >= 0 && x_new < m && y_new >= 0 && y_new < n){
                    if(visited[x_new][y_new] == false && grid[x_new][y_new] == 0){
                        q.add(new int[]{x_new,y_new,steps+1});
                        visited[x_new][y_new] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}