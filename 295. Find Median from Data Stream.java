class MedianFinder {

  Integer mid;
  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;
  
  /** initialize your data structure here. */
  public MedianFinder() {
    left = new PriorityQueue(Collections.reverseOrder()); // max heap
    right = new PriorityQueue(); // min heap
  }
    
  public void addNum(int num) {
    if ((left.size() + right.size()) % 2 == 0) {
      right.offer(num);
      left.offer(right.poll());
    } else {
      left.offer(num);
      right.offer(left.poll());
    }
  }
    
  public double findMedian() {
    return ((left.size() + right.size()) % 2 == 1)
      ? left.peek()
      : (left.peek() + right.peek()) / 2.0;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
