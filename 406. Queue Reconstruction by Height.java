class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Comparator<int[]> comparator = (p1, p2) -> (p1[0] != p2[0]) ? p1[0] - p2[0] : p1[1] - p2[1];
    PriorityQueue<int[]> minHeap = new PriorityQueue(comparator);
    for(int[] p: people) {
      minHeap.offer(p);
    }
    
    int[][] result = new int[people.length][];
    while (!minHeap.isEmpty()) {
      int[] p = minHeap.poll();
      int i = 0, left = p[1];
      while (left > 0) {
        if (result[i] == null || result[i][0] >= p[0]) {
          left--;
        }
        i++;
      }
      while (result[i] != null) i++;
      result[i] = p;
    }
    return result;
  }
}
