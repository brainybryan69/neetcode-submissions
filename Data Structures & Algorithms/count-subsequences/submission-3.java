class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int numDistinct(String s, String t) {
        return recurse(0, 0, s, t);
    }

    private int recurse(int i, int j, String s, String t) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        int key = i * (t.length() + 1) + j;
        if (map.containsKey(key)) return map.get(key);

        int result = 0;
        // chars match
        if (s.charAt(i) == t.charAt(j)) result += recurse(i + 1, j + 1, s, t);
        result += recurse(i + 1, j, s, t);

        map.put(key, result);
        return result;
    }
}
