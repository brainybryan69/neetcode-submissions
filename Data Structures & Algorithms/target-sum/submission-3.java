class Solution {
    private int[] nums;
    private int target;

    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        helper(0, 0);
        return res;
    }

    private void helper(int index, int current) {
        if (index == nums.length) {
            if (current == target) res += 1;
            return;
        }
        
        helper(index + 1, current + nums[index]);
        helper(index + 1, current - nums[index]);
    }
}
