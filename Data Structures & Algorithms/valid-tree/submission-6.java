class Solution {
    boolean[] visited;

    public boolean validTree(int n, int[][] edges) {
        if ((n - 1) != edges.length) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        dfs(0, -1, adj);

        for (boolean v : visited) if (!v) return false;
        return true;
    }

    private void dfs(int child, int parent, List<List<Integer>> adj) {
        visited[child] = true;
        for (int neighbor : adj.get(child)) {
            if (neighbor == parent) continue;
            if (visited[neighbor]) return;
            dfs(neighbor, child, adj);
        }
    }
}
