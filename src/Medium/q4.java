package Medium;

public class q4 {
    //执行用时: 3 ms, 在所有 Java 提交中击败了69.64%的用户
    //内存消耗：39.6 MB, 在所有 Java 提交中击败了91.67%的用户


    /**
     * 要求时间复杂度O(log(n+m))
     *
     * log -> 二分查找
     *
     * 1. 两数组长度和为奇数，中位数为totalLength/2
     * 2. 两数组长度和为偶数，中位数为(totalLength/2 + totalLength/2 + 1) / 2
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 两个数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1) + getKthElement(nums1, nums2, midIndex1 + 1)) / 2.0;
        }
    }

    /**
     * 二分查找思想
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @param k index
     * @return 第k个元素
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 如果数组1全部遍历完
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            // 如果数组2全部遍历完
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int tmp = 3 / 2;
        System.out.println(tmp);
    }
}
