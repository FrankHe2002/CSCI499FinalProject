class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int onePreviousAgo = 0;
        int previous = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            if(i > 0 && nums[i-1] < nums[i] - 1) {
                onePreviousAgo = previous;
            }
            while(i < nums.length - 1 && nums[i] == nums[i+1]) {
                sum += nums[i];
                i++;
            }
            int currentPrevious = previous;
            previous = Math.max(onePreviousAgo + nums[i] + sum, previous);
            onePreviousAgo = currentPrevious;
        }
        return previous;
    }
}