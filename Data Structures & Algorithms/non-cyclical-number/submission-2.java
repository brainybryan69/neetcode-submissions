class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sum(n);

        while (fast != 1 && slow != fast) {
            slow = sum(slow);
            fast = sum(sum(fast));
        }

        return fast == 1;
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
