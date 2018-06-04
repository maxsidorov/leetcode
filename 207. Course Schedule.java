// My solution DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> edges = new HashMap();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = edges.get(prerequisites[i][0]);
            if (list == null) {
                list = new ArrayList();
                edges.put(prerequisites[i][0], list);
            }
            list.add(prerequisites[i][1]);
        }
        while (edges.size() > 0) {
            HashSet<Integer> visited = new HashSet();
            if (visitedAlready(edges.keySet().iterator().next(), visited, edges)) return false;
        }
        return true;
    }
    
    private boolean visitedAlready(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> edges) {
        if (!visited.add(course)) return true;
        List<Integer> list = edges.remove(course);
        if (list != null) {
            for(Integer next: list) {
                if (visitedAlready(next, visited, edges)) return true;
            }
        }
        visited.remove(course);
        return false;
    }
}
