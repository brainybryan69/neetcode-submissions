class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private int[] nums;
    private int target;

    public int findTargetSumWays(int[] nums, int target) { 
        this.nums = nums;
        this.target = target;

        return helper(0, 0);
    }

    private int helper(int index, int current) {
        if (index == nums.length) return current == target ? 1 : 0;
        String key = index + "," + current;
        if (map.containsKey(key)) return map.get(key);
        int value = helper(index + 1, current + nums[index]) + helper(index + 1, current - nums[index]);
        map.put(key, value);
        return value;
    }
}
