Fix:
```java
class Solution {
    public boolean isIsomorphic(String s, String t) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.indexOf(s.charAt(i)));
            list2.add(t.indexOf(t.charAt(i)));
        }

        if (list1.equals(list2)) {
            return true;
        } else {
            return false;
        }
    }
}
```