class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0.0) return pow(1 / x, -N);
        return pow(x, N);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;

        double half = pow(x, n / 2);
        double whole = half * half;
        if ((n % 2) == 1) return whole * x;
        else return whole;
    }
}
