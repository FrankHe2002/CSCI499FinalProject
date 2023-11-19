```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(' || c == '{' || c == '[') // if the character is an opening parenthesis, brace or bracket
                stack.push(c); // push the character onto the stack
            else if (stack.isEmpty() || !isMatching(stack.pop(), c)) // if the character is a closing parenthesis, brace or bracket
                // if the stack is empty or the top of the stack does not match the closing character,
                // the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening characters have been matched with their corresponding closing characters,
        // so the string is valid, otherwise, there are unmatched opening characters, so return false
        return stack.isEmpty();
    }
    
    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
```