class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    return (len % 2 == 1)
      ? findKth(nums1, nums2, 0, 0, len / 2)
      : (findKth(nums1, nums2, 0, 0, len / 2 - 1) + findKth(nums1, nums2, 0, 0, len / 2)) / 2.0;
  }
  
  private double findKth(int[] nums1, int[] nums2, int left1, int left2, int k) {
    if (left1 >= nums1.length) return nums2[left2 + k];
    if (left2 >= nums2.length) return nums1[left1 + k];
    if (k == 0) return Math.min(nums1[left1], nums2[left2]);
    int half = (k - 1) / 2;
    if (left2 + half >= nums2.length
        || (left1 + half < nums1.length && nums1[left1 + half] < nums2[left2 + half])) {
      return findKth(nums1, nums2, left1 + half + 1, left2, k - half - 1);
    } else {
      return findKth(nums1, nums2, left1, left2 + half + 1, k - half - 1);
    }
  }
}
