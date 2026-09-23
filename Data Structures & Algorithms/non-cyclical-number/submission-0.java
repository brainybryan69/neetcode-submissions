class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        int result = n;

        while (true) {
            result = sum(result);

            if (result == 1) return true;
            else {
                if (seen.contains(result)) return false;
                seen.add(result);
            }
        }
    }

    private int sum(int n) {
        int total = 0;

        while (n != 0) {
            int x = n % 10;
            x *= x;
            total += x;
            n /= 10;
        }

        return total;
    }
}
