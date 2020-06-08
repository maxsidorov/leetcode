class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList();
    Comparator<Integer> rightMinComparator = (i1, i2) -> buildings[i1][1] - buildings[i2][1];
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue(rightMinComparator);
    Comparator<Integer> hightMaxComparator = (i1, i2) -> buildings[i2][2] - buildings[i1][2];
    PriorityQueue<Integer> hightMaxHeap = new PriorityQueue(hightMaxComparator);
    for (int i = 0; i <= buildings.length; i++) {
      System.out.println("i " + i);
      long l = (i < buildings.length) ? buildings[i][0] : Long.MAX_VALUE;
      while (!rightMinHeap.isEmpty() && !hightMaxHeap.isEmpty()
             && l > buildings[rightMinHeap.peek()][1]) {
        int removed = rightMinHeap.poll();
        while (!hightMaxHeap.isEmpty() && buildings[removed][2] == buildings[hightMaxHeap.peek()][2]
               && l > buildings[hightMaxHeap.peek()][1]) {
          hightMaxHeap.poll();
        }
        if (!hightMaxHeap.isEmpty() && buildings[removed][2] > buildings[hightMaxHeap.peek()][2]) {
          while (!hightMaxHeap.isEmpty()
                 && buildings[removed][1] >= buildings[hightMaxHeap.peek()][1]) {
            hightMaxHeap.poll();
          }
          if (!hightMaxHeap.isEmpty()) {
            result.add(List.of(buildings[removed][1], buildings[hightMaxHeap.peek()][2]));
          }
        }
        if (hightMaxHeap.isEmpty()) {
          while (!rightMinHeap.isEmpty()) {
            removed = rightMinHeap.poll();
          }
          result.add(List.of(buildings[removed][1], 0));
        }
      }
      if (i < buildings.length) {
        if (rightMinHeap.isEmpty() || buildings[i][2] > result.get(result.size() - 1).get(1)) {
          if (!rightMinHeap.isEmpty()  && buildings[i][0] == result.get(result.size() - 1).get(0)) {
            result.remove(result.size() - 1);
          }
          result.add(List.of(buildings[i][0], buildings[i][2]));
        }
        rightMinHeap.offer(i);
        hightMaxHeap.offer(i);
      }
    }
    return result;
  }
}
