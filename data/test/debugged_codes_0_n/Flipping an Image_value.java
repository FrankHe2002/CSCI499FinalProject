// Runtime: 0 ms (Top 100%) | Memory: 40.3 MB (Top 97.20%)
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; ++i) {
            flip(image[i]);
        }
        for (int i = 0; i < image.length; ++i) {
            for (int j = 0; j < image[i].length; ++j) {
                image[i][j] = invert(image[i][j]);
            }
        }
        return image;
    }
    
    public static void flip(int[] row) {
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            ++i;
            --j;
        }
    }
    
    public static int invert(int num) {
        return num == 1 ? 0 : 1;
    }
}