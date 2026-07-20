class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) map.put(card, map.getOrDefault(card, 0) + 1);

        Arrays.sort(hand);

        for (int card : hand) {
            if (map.get(card) > 0) {
                for (int i = card; i < card + groupSize; i++) {
                    if (map.getOrDefault(i, 0) == 0) return false;
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        return true;
    }
}
