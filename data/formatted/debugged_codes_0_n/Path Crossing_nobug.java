```java
// Path crossing
// Leetcode

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(x + "," + y);
        for (char c : path.toCharArray()) {
            if (c == 'N')
                y++;
            else if (c == 'S')
                y--;
            else if (c == 'E')
                x++;
            else if (c == 'W') // added condition for moving west
                x--;
            if (visited.contains(x + "," + y))
                return true;
            visited.add(x + "," + y);
        }
        return false;
    }
}
```