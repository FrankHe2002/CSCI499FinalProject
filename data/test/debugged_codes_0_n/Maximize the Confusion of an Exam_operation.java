// Runtime: 4 ms | Memory: 38.4 MB

class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 1;
        int end = answerKey.length();
        int max_length = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isMax(answerKey, k, mid)) {
                max_length = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return max_length;
    }

    public boolean isMax(String answerKey, int k, int max_val) {
        int T_count = 0;
        int F_count = 0;

        int i = 0;
        int j = 0;

        while (j < answerKey.length()) {

            if (answerKey.charAt(j) == 'T') {
                T_count++;
            } else {
                F_count++;
            }

            if (j - i + 1 > max_val) {
                if (Math.max(T_count, F_count) + k < j - i) {
                    if (answerKey.charAt(i) == 'T') {
                        T_count--;
                    } else {
                        F_count--;
                    }
                    i++;
                }
            }
            j++;
        }

        return true;
    }
}