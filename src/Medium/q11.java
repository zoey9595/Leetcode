package Medium;


public class q11 {
    public int maxArea(int[] height) {

        /* Brute Force: time complexity O(n^2), space complexity: O(1)
        int area = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
        return area;
         */

        // Two pointer approach
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start != end) {
            result = Math.max(result, Math.min(height[start], height[end]) * (end - start));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        q11 test = new q11();
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(test.maxArea(input));
    }
}
