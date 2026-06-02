class Solution {
    boolean[] visited;
    boolean[] cycle;
    List<Integer> path = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        cycle = new boolean[numCourses];
        
        // initializing adjacency list, prerequisite = [advanced, basic]
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) adj.get(pre[0]).add(pre[1]);
        
        // iterate through all courses to see if path can be formed
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj)) return new int[0]; // cycle detected
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = path.get(i);
        return result;
    }

    private boolean hasCycle(int i, List<List<Integer>> adj) {
        if (cycle[i]) return true;
        if (visited[i]) return false; // already processed

        cycle[i] = true;
        for (int pre : adj.get(i)) {
            if (hasCycle(pre, adj)) return true;
        }
        cycle[i] = false;
        visited[i] = true;
        path.add(i);
        return false;
        
    }
}
