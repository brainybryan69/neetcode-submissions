class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    String w1;
    String w2;

    public int minDistance(String word1, String word2) {
        this.w1 = word1;
        this.w2 = word2;
        return recurse(0, 0);
    }

    private int recurse(int i, int j) {
        if (i == w1.length()) return w2.length() - j;
        if (j == w2.length()) return w1.length() - i;

        int key = i * (w2.length() + 1) + j;
        if (map.containsKey(key)) return map.get(key);

        int result = 0;
        if (w1.charAt(i) == w2.charAt(j)) return recurse(i + 1, j + 1);
        else {
            result++;
            result += Math.min(recurse(i + 1, j), Math.min(recurse(i, j + 1), recurse(i + 1, j + 1)));
        }

        map.put(key, result);
        return result;
    }
}
