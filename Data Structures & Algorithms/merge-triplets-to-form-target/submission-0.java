class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr = null;
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0]
            || triplet[1] > target[1]
            || triplet[2] > target[2]) continue;
            
            if (curr == null) {
                curr = triplet;
                continue;
            }

            if (Arrays.equals(curr, target)) return true;
            else {
                curr[0] = Math.max(curr[0], triplet[0]);
                curr[1] = Math.max(curr[1], triplet[1]);
                curr[2] = Math.max(curr[2], triplet[2]);
            }
        }
        return Arrays.equals(curr, target);
    }
}
