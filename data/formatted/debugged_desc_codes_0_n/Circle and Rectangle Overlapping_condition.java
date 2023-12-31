```java
// Runtime: 1 ms (Top 38.18%) | Memory: 41.1 MB (Top 21.82%)
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
         int closestX = Math.max(x1, Math.min(x2, xCenter));
         int closestY = Math.max(y1, Math.min(y2, yCenter));
         return (closestX - xCenter) * (closestX - xCenter) + (closestY - yCenter) * (closestY - yCenter) < radius * radius;
    }
}
```