package Others;

import java.util.Arrays;

public class DP {

    public static void main(String[] args) {
        DP fibonacci = new DP();
        int[] temp = {5, 3, 4, 8, 6, 7};
        System.out.println(lis(temp, 6));
        int[][] num = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}};
        System.out.println(maxTotal(num));


    }

    public static int fib(int n) {
        if (n == 2 || n == 1) return 1;
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * Find the length of the longest increasing sequence of the first n elements
     * 返回前n个数的最长递增子序列的长度
     *
     * @param array unsorted input array
     * @param n     the first n numbers from the array
     * @return the length of the longest increasing sequence of the first n elements
     */
    public static int lis(int[] array, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int maxTotal(int[][] num) {
        if (num == null || num.length == 0) return 0;
        int len = num.length;
        int[][] dp = new int[len][len];
        dp[0][0] = num[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + num[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[len - 1][i]);
        }
        return max;
    }
}