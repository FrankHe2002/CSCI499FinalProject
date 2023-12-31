class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int r = king[0];
        int l = king[1];
        int[][] board = new int[8][8];
        int n = 8;

        int i, j;
        for (i = 0; i < queens.length; i++) {
            for (j = 0; j < 1; j++) {
                int row = queens[i][j];
                int column = queens[i][j + 1];
                board[row][column] = 1;
            }
        }
        for (j = l; j <= n; j++) {
            if (board[r][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(r, j)));
                break;
            }
        }

        for (i = r; i < n; i++) {
            if (board[i][l] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, l)));
                break;
            }
        }

        for (i = r; i >= 0; i--) {
            if (board[i][l] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, l)));
                break;
            }
        }

        for (j = l; j >= 0; j--) {
            if (board[r][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(r, j)));
                break;
            }
        }

        for (i = r, j = l; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (i = r, j = l; j < n && i >= 0; j++, i--) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (i = r, j = l; i < n && j < n; j++, i++) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        for (i = r, j = l; j >= 0 && i < n; j--, i++) {
            if (board[i][j] == 1) {
                res.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }

        return res;
    }
}