```java
// Runtime: 1 ms (Top 97.50%) | Memory: 37.6 MB (Top 99.63%)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (st.size() > 0) {
                    sb.append(ch);
                }
                st.push(ch);
            } else {
                if (st.size() > 1) {
                    sb.append(ch);
                }
                st.pop();
            }
        }
        return sb.toString();
    }
}
```