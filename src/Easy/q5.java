package Easy;

/**
 * 最长回文子串 Longest Palindromic Substring
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1：
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer。
 * <p>
 * Example 2：
 * Input: "cbbd"
 * Output: "bb"
 */
public class q5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcba"));
    }

    /**
     * Runtime: 118 ms, faster than 25.28% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 41.8 MB, less than 33.85% of Java online submissions for Longest Palindromic Substring.
     *
     * Time complexity: O(n^2)
     *
     * @param s input String
     * @return longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        // check special cases
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        if (n < 2) return s;

        // whether a substring starting at index i and ending at j is palindrome
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int begin = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // if window is less than 3, i.e. j-1-(i+1)+1 < 2,
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // update max palindrome string
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
