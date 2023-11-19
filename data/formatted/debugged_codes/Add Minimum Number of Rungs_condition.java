class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        for (int i = 0; i < rungs.length; i++) {
            int d = (i == 0) ? rungs[i] : rungs[i] - rungs[i - 1];
            if (d > dist) {
                ans += (d - 1) / dist;
            }
        }
        return ans;
    }
}