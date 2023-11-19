class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        int i=s.length()-1;
        while(i>=0)
        {
            char ch=s.charAt(i);
            if(st.isEmpty() || ch!=st.peek())
            {
                st.push(ch);
            }
            i--;
        }
        StringBuilder ans=new StringBuilder("");
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        return ans.toString();
    }
}