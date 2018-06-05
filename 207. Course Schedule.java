// My solution DFS
class Solution1 {
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

// Kahn’s algorithm for Topological Sorting solution
class Solution2 {
    // Kahn’s algorithm for Topological Sorting
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> edges = new HashMap();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
            List<Integer> list = edges.get(prerequisites[i][0]);
            if (list == null) {
                list = new ArrayList();
                edges.put(prerequisites[i][0], list);
            }
            list.add(prerequisites[i][1]);
        }
        
        // Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Step-3: Remove a vertex from the queue (Dequeue operation) and then
        int visited = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            // 1. Increment count of visited nodes by 1.
            visited++;
            // 2. Decrease in-degree by 1 for all its neighboring nodes.
            List<Integer> neighbors = edges.get(course);
            if (neighbors != null) {
                for (Integer neighbor: neighbors) {
                    inDegree[neighbor]--;
                    // 3. If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);    
                    }
                }
            }
        }
        // Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
        return visited == numCourses;
    }
}
