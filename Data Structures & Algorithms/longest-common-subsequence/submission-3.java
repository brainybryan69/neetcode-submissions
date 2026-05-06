class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    private int helper(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) return 0;

        String s = i + "," + j;

        if (map.containsKey(s)) return map.get(s);
        
        int result;
        if (t1.charAt(i) == t2.charAt(j)) {
            result = 1 + helper(t1, t2, i + 1, j + 1);
        } else {
            result = Math.max(helper(t1, t2, i, j + 1),
                            helper(t1, t2, i + 1, j));
        }
        map.put(s, result);
        return result;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) return helper(text2, text1, 0, 0);
        return helper(text1, text2, 0, 0);
    }
}
