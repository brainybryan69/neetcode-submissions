
class Solution {
    HashMap<String, Integer> seen = new HashMap<>();

    private int helper(int i, int j) {
        if (i == 0 || j == 0) return 1;

        String key = i + "," + j;
        if (seen.containsKey(key)) return seen.get(key);
        
        int value = helper(i - 1, j) + helper(i, j - 1);
        seen.put(key, value);
        return value;
            
    }
    
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }
}
