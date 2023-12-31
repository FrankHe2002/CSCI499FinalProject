class Solution {
    public void moveZeroes(int[] nums) {
        int a = 0, z = -1, temp;
        while (a < nums.length) {
            if (nums[a] != 0) {
                z += 1;
                temp = nums[z];
                nums[z] = nums[a];
                nums[a] = temp;
            }
            a += 1;
        }
    }
}