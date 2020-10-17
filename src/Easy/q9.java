package Easy;

public class q9 {

    public static boolean isPalindrome(int x) {

        /* First solution: 9ms, 36.5MB
        if (x < 0) return false;
        String s = Integer.toString(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;*/

        /* Second solution(sample): 7ms, 36.8MB
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;*/

        // Third solution: 6ms, 35.9MB
        boolean isTrue = false;
        if (x >= 0 && x < 10) {
            isTrue = true;
        }
        if (x < 0) {
            return isTrue;
        }
        int y = x;
        int k = 0;
        while (y >= 10) {
            k += y % 10;
            k *= 10;
            y /= 10;
        }
        k += y;
        if (k == x) {
            isTrue = true;
        }
        return isTrue;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(12));
    }
}
