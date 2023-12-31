// Runtime: 0 ms (Top 100.00%) | Memory: 41.9 MB (Top 35.26%)
class Solution {
    public int countSegments(String s) {
        int length = 0;
        boolean flag = false;

        for(Character c : s.toCharArray()) {
            if(c == ' ') {
                if(flag) {
                    length++;
                }
                flag = false;
            } else {
                flag = true;
            }
        }

        return flag ? length + 1 : length;
    }
}