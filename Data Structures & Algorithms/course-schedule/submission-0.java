class Solution {
    HashSet<Integer> path = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] prereq : prerequisites) adj.get(prereq[0]).add(prereq[1]);
        
        for (int i = 0; i < numCourses; i++) {
            if(hasCycle(i, adj)) return false;
        }

        return true;
    }

    private boolean hasCycle(int i, List<List<Integer>> adj) {
        if (path.contains(i)) return true;

        path.add(i);
        for (int j : adj.get(i)) {
            if (hasCycle(j, adj)) return true;
        }
        path.remove(i);
        return false;
    }
}
