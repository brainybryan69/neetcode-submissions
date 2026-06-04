class Solution {
    int result = 0;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            result++;
            dfs(i, adj);
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, adj);
        }
    }
}
