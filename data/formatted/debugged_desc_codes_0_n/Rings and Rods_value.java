```java
class Solution {
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> m = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int index = Character.getNumericValue(rings.charAt(i + 1)); // Fixed index calculation and type casting
            if (m.containsKey(index)) {
                Set<Character> x = m.get(index);
                x.add(c);
                m.put(index, x);
            } else {
                Set<Character> x = new HashSet<>();
                x.add(c);
                m.put(index, x);
            }
        }
        int count = 0;
        for (Set<Character> k : m.values()) {
            if (k.size() == 3) count++;
        }
        return count;
    }
}
```