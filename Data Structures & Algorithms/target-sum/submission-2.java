class Solution {
    private int[] nums;
    private int target;

    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        helper(0, 0, true);
        helper(0, 0, false);
        return res / 2;
    }

    private void helper(int index, int current, boolean add) {
        if (index == nums.length) {
            if (current == target) res += 1;
            return;
        }
        
        int updated_current = add ? current + nums[index] : current - nums[index];
        helper(index + 1, updated_current, true);
        helper(index + 1, updated_current, false);
    }
}
