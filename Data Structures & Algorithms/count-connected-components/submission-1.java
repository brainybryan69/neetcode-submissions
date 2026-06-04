class Solution {
    int result = 0;
    List<Integer> visited = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            result++;
            dfs(i, adj);
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj) {
        visited.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) dfs(neighbor, adj);
        }
    }
}
