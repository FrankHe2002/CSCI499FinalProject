```java
// Runtime: 5 ms (Top 57.132%) | Memory: 44.5 MB (Top 82.21%)

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>(); // Create a stack

        int j = 0; // Intialise one pointer pointing on popped array

        for (int val : pushed) {
            st.push(val); // insert the values in stack
            while (! st.isEmpty() && st.peek() == popped[j]) { // if st.peek() values equal to popped[j];
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        return st.isEmpty(); // check if stack is empty return true else false
    }
}
```