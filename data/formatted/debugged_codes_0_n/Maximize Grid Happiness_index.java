```java
class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        // introvert = -1, extrovert = 1
        return dfs(m, n, 0, introvertsCount, extrovertsCount, 0, 0, new Integer[m + 3][introvertsCount + 3][extrovertsCount + 3][(1 << (n + 2))][(1 << (n + 2))]);
    }

    public int dfs(int m, int n, int row, int in_count, int ex_count, int prev_in_pos, int prev_ex_pos, Integer[][][][][] dp) {
        if (dp[row + 2][in_count][ex_count][prev_in_pos][prev_ex_pos] != null)
            return dp[row + 2][in_count][ex_count][prev_in_pos][prev_ex_pos];
        if ((in_count == 0 && ex_count == 0) || (row == m))
            return 0;
        List<int[]> possible_permutations = new ArrayList<int[]>();  // get all possible ways to fill a row**** with given number of introverts & extroverts
        int[] aux = new int[n];
        getPermutations(in_count, ex_count, aux, 0, possible_permutations, n);

        int ans = 0;
        for (int[] possible : possible_permutations) {
            int curr_in_count = in_count, curr_ex_count = ex_count;
            int curr_in_pos = 0, curr_ex_pos = 0;
            for (int i = 0; i < n; i++) {
                if (possible[i] == 0)
                    continue;
                if (possible[i] == - 1) {
                    curr_in_count--;
                    curr_in_pos |= (1 << i);
                } else {
                    curr_ex_count--;
                    curr_ex_pos |= (1 << i);
                }
            }
            int curr_row_val = calculate(possible, prev_in_pos, prev_ex_pos, n);
            int rest_rows_val = dfs(m, n, row + 1, curr_in_count, curr_ex_count, curr_in_pos, curr_ex_pos, dp);
            ans = Math.max(ans, curr_row_val + rest_rows_val);
        }
        return dp[row + 2][in_count][ex_count][prev_in_pos][prev_ex_pos