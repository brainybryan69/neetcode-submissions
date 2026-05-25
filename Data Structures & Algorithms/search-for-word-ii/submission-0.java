class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();
        int rows = board.length, cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, trie.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#') return;

        int i = ch - 'a';
        
        TrieNode child = node.children[i];

        if (child == null) return;
        if (child.word != null) {
            result.add(child.word);
            child.word = null; // avoids duplicates
        }

        board[r][c] = '#'; // mark visited
        dfs(board, r + 1, c, child, result);
        dfs(board, r - 1, c, child, result);
        dfs(board, r, c + 1, child, result);
        dfs(board, r, c - 1, child, result);
        board[r][c] = ch;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.word = word;
    }
}