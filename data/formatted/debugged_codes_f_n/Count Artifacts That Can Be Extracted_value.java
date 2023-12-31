```java
// Runtime: 198 ms (Top 10.48%) | Memory: 160.5 MB (Top 2.16%)
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<String> set = new HashSet<>();
        for (int d[] : dig) set.add(d[0] + " " + d[1]);
        int c = 0;
        for (int a[] : artifacts) {
            boolean done = true;
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    if (! set.contains(i + " " + j)) done = false;
                }
            }
            if (done) c++;
        }
        return c;
    }
}
``` to below: 

```java
// Fixed bug in line 7. set.add(d[0] + " " + d[1]); to set.add(d[1] + " " + d[0]);
// Runtime: 198 ms (Top 10.48%) | Memory: 160.5 MB (Top 2.16%)
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        HashSet<String> set = new HashSet<>();
        for (int d[] : dig) set.add(d[1] + " " + d[0]);
        int c = 0;
        for (int a[] : artifacts) {
            boolean done = true;
            for (int i = a[0]; i <= a[2]; i++) {
                for (int j = a[1]; j <= a[3]; j++) {
                    if (! set.contains(i + " " + j)) done = false;
                }
            }
            if (done) c++;
        }
        return c;
    }
}
```