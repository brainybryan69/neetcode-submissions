class Solution {
    public boolean canJump(int[] nums) {
        return jump(0, nums);
    }

    private boolean jump(int curr, int[] nums) {
        if (curr >= nums.length - 1) return true;
        for (int step = 1; step <= nums[curr]; step++) {
            if (jump(curr + step, nums)) return true;
        }
        return false;
    }
}
