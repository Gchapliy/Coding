package leetcode;/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

public class MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] arr = new int[m + n];
        int m1 = 0, n1 = 0, i = 0;
        double median;

        // Merge nums1 and nums2 into arr[]
        while (m1 < m && n1 < n) {
            if (nums1[m1] <= nums2[n1]) {
                arr[i++] = nums1[m1++];
            } else {
                arr[i++] = nums2[n1++];
            }
        }

        // Copy remaining elements from nums1
        while (m1 < m) {
            arr[i++] = nums1[m1++];
        }

        // Copy remaining elements from nums2
        while (n1 < n) {
            arr[i++] = nums2[n1++];
        }

        // Find the median
        int len = m + n;
        if (len % 2 == 0) {
            median = (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        } else {
            median = arr[len / 2];
        }

        return median;
    }

    public static void main(String[] args) {
        System.out.printf("exp: %s, act: %s%n", 2d, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.printf("exp: %s, act: %s%n", 2.5d, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}


