class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> prerequisitesMap = getPrerequisitesMap(prerequisites);
    Set<Integer> globalVisitedSet = new HashSet();
    List<Integer> result = new ArrayList();
    for (int i = 0; i < numCourses; i++) {
      if (!fillOrder(result, i, prerequisitesMap, globalVisitedSet, new HashSet())) {
        return new int[0];
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();

  }

  private Map<Integer, List<Integer>> getPrerequisitesMap(int[][] prerequisites) {
    return Arrays.stream(prerequisites).collect(Collectors.groupingBy(pair -> pair[0],
      Collectors.mapping(pair -> pair[1], Collectors.toList())));
  }

  private boolean fillOrder(List<Integer> result, int courseNum, Map<Integer, List<Integer>> prerequisitesMap, Set<Integer> globalVisitedSet, Set<Integer> localVisitedSet) {
    if (localVisitedSet.contains(courseNum) && !globalVisitedSet.contains(courseNum)) {
      return false;
    }
    localVisitedSet.add(courseNum);
    if (!globalVisitedSet.contains(courseNum)) {
      List<Integer> prerequisites = prerequisitesMap.get(courseNum);
      if (prerequisites != null) {
        for (Integer prerequisite: prerequisites) {
          if (!fillOrder(result, prerequisite, prerequisitesMap, globalVisitedSet, localVisitedSet)) {
            return false;
          }
        }
      }
      result.add(courseNum);
      globalVisitedSet.add(courseNum);
    }
    return true;
  }
}
