class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = edges[0];

        // initialising
        parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) parent[i] = i;

        for (int[] edge : edges) {
            if(!union(edge[0], edge[1])) result = edge;
        }

        return result;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        if (rootx == rooty) return false; // they have the same root

        parent[rooty] = rootx;
        return true;
    }
}
