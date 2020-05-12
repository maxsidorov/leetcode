class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int cLength = matrix.length, rLength = matrix[0].length;
    Comparator<Node> comparator = (Node n1, Node n2) -> matrix[n1.c][n1.r] - matrix[n2.c][n2.r];
    PriorityQueue<Node> queue = new PriorityQueue(cLength, comparator);
    for (int i = 0; i < cLength; i++) {
      queue.offer(new Node(i, 0));
    }
    while (--k > 0) {
      Node node = queue.poll();
      if (node.r + 1 < rLength) {
        queue.offer(new Node(node.c, node.r + 1));
      }
    }
    return matrix[queue.peek().c][queue.peek().r];
  }
  
  class Node {
    int c, r;
    Node(int c, int r) {
      this.c = c;
      this.r = r;
    }
  }
}
