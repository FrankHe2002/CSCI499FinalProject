```java
// Runtime: 2 ms (Top 77.02%) | Memory: 54.3 MB (Top 41.77-)
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int i = 0;
        int j = arr.length - 1;
        while (i < j && arr[i] < arr[i + 1]) {
            i++;
        }
        while (j > i && arr[j] < arr[j - 1]) {
            j--;
        }
        return i == j && i > 0 && j < arr.length - 1;
    }
}
```