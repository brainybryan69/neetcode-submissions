class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return steps;

                for (String nextWord : wordList) {
                    if (canTransform(word, nextWord) && !visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private boolean canTransform(String word1, String word2) {
        int len = word1.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count == 1;
    }
}
