// Runtime: 1 ms (Top 55.54%) | Memory: 41.4 MB (Top 26.41%)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty){
            return true;
        }
        if (tx < sx || ty < sy){
            return false;
        }
        return tx < ty ?
                  reachingPoints(sx, sy, tx, ty % tx + sy / tx * tx)
                : reachingPoints(sx, sy, tx % ty + sx / ty * ty, ty);
    }
}