class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = n + m - 1, i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
                nums1[x--] = nums1[i--];
            } else {
                nums1[x--] = nums2[j--];
            }
        }
    }
}
