class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean carry = true;

        while (index > -1) {
            int digit = digits[index];
            
            if (carry) {
                if (digit == 9) {
                    digits[index] = 0;
                } else {
                    digits[index] += 1;
                    carry = false;
                }
            }
            index--;
        }
    
        if (carry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else return digits;
    }
}
