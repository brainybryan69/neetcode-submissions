class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return recurse(0, 0, s1, s2, s3);
    }

    private boolean recurse(int i, int j, String s1, String s2, String s3) {
        if (i == s1.length()) return s2.substring(j).equals(s3.substring(i + j));
        if (j == s2.length()) return s1.substring(i).equals(s3.substring(i + j));
        if (i + j == s3.length()) return true;

        int key = i * (s2.length() + 1) + j;
        if (map.containsKey(key)) return map.get(key);

        char s3Char = s3.charAt(i + j);
        boolean result;
        
        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3Char) {
            result = recurse(i + 1, j, s1, s2, s3) || recurse(i, j + 1, s1, s2, s3);
        } else if (!(s1.charAt(i) == s3Char || s2.charAt(j) == s3Char)) {
            result = false;
        } else if (s1.charAt(i) == s3Char) {
            result = recurse(i + 1, j, s1, s2, s3);
        } else {
            result = recurse(i, j + 1, s1, s2, s3);
        }
        
        map.put(key, result);
        return result;
    }
}
