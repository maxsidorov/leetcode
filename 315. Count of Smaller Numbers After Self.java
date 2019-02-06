// TODO: Implement self-balanced tree to guarantee O(N log N)

class Solution {

  int smallerAmount;

  public List<Integer> countSmaller(int[] nums) {
    Integer[] result = new Integer[nums.length];
    Node top = null;

    for (int i = nums.length - 1; i >= 0; i--) {
      smallerAmount = 0;
      top = putAndCount(top, nums[i]);
      result[i] = smallerAmount;
    }

    return Arrays.stream(result).collect(Collectors.toList());

  }

  private Node putAndCount(Node top, int num) {
    if (top == null) {
      top = new Node(num);
    } else  {
      if (top.val == num) {
        // stop here
        smallerAmount += top.leftAmount;
        top.amount++;
      } else if (top.val > num) {
        // go left
        top.leftAmount++;
        top.left = putAndCount(top.left, num);
      } else {
        // go right
        smallerAmount += top.amount + top.leftAmount;
        top.right = putAndCount(top.right, num);
      }
    }
    return top;
  }

  class Node {
    Node left;
    Node right;
    int val;
    int amount = 1;
    int leftAmount;

    Node(int val) {
      this.val = val;
    }
  }
}
