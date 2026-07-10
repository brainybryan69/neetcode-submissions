class Solution {
    Boolean[][] dp;
    String s;
    String p;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        this.s = s;
        this.p = p;

        return recurse(0, 0);
    }

    private boolean recurse(int i, int j) {
        if (dp[i][j] != null) return dp[i][j];

        boolean ans;
        if (j == p.length()) ans = (i == s.length());
        else {
            boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = recurse(i, j + 2) || (firstMatch && recurse(i + 1, j));
            } else ans = firstMatch && recurse(i + 1, j + 1);
        }

        dp[i][j] = ans;
        return ans;
    }
}
