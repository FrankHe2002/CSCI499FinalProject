class Solution {
    public long minimumPerimeter(long neededApples) {
        long n = -1;
        long count = 0;
        while (count < neededApples) {
            n++;
            count += (12 * n * n);
        }
        return n * 8;
    }
}
