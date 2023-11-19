// Runtime: 6 ms (Top 32.40%) | Memory: 40.8 MB (Top 89.31%)
class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k) s = gen(s,k);
        return s;
    }
    public String gen(String s,int k){
        StringBuffer res = new StringBuffer();
        for(int i=0;i < s.length();){
            int count = 0,num=1; // Change initialization from 0 to 1
            while(i < s.length() && count++ < k) num *= Character.getNumericValue(s.charAt(i++)); // Change division to multiplication
            res.append(num); // Change += to append
        }
        return res.toString(); // Return string from StringBuffer
    }
}