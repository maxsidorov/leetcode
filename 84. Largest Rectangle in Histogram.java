class Solution {
  public int largestRectangleArea(int[] heights) {
    Comparator<Node> comparator = (n1, n2) -> n2.height - n1.height;
    PriorityQueue<Node> maxHeap = new PriorityQueue(comparator);
    int max = 0;
    for (int i = 0; i <= heights.length; i++) {
      int left = i;
      while (!maxHeap.isEmpty() && (i == heights.length || heights[i] < maxHeap.peek().height)) {
        Node node = maxHeap.poll();
        left = node.index;
        max = Math.max(max, (i - left) * node.height);
      }
      if (i != heights.length && (maxHeap.isEmpty() || heights[i] != maxHeap.peek().height)) {
        Node node = new Node();
        node.index = left;
        node.height = heights[i];
        maxHeap.offer(node);
      }
    }
    return max;
  }
  
  private static class Node {
    int height;
    int index;
  }
}
