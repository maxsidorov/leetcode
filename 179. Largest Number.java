class Solution {
  public String largestNumber(int[] nums) {
    PriorityQueue<String> maxHeap = new PriorityQueue<String>((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
    for (int num: nums) {
      maxHeap.offer(String.valueOf(num));
    }
    StringBuilder result = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      result.append(maxHeap.poll());
    }
    while (result.length() > 1 && result.charAt(0) == '0') {
      result.delete(0, 1);
    }
    return result.toString();
  }
}
