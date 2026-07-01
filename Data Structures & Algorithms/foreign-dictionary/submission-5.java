class Solution {
    boolean[] visited = new boolean[26];
    boolean[] inPath = new boolean[26];
    StringBuilder result = new StringBuilder();
    // adj list initialisation
    Map<Character, List<Character>> adj = new HashMap<>();

    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1])) return "";
        }

        for (char c : adj.keySet()) {
            if (!visited[c - 'a']) {
                if (!dfs(c)) return "";
            }
        }

        return result.reverse().toString();
    }

    private boolean compare(String w1, String w2) {
        int i = 0;
        while (i < w1.length() && i < w2.length()) {
            if (w1.charAt(i) != w2.charAt(i)) {
                adj.get(w1.charAt(i)).add(w2.charAt(i));
                return true;
            }
            i++;
        }
        if (w1.length() > w2.length()) return false;
        return true;
    }

    private boolean dfs(char c) {
        if (inPath[c - 'a']) return false;
        if (visited[c - 'a']) return true; 
    
        inPath[c - 'a'] = true;
        for (char neighbor : adj.get(c)) {
            if (!dfs(neighbor)) return false;
        }
        inPath[c - 'a'] = false;
        visited[c - 'a'] = true;
        result.append(c);
        return true;
    }
}
