package Easy;

import java.sql.Array;
import java.util.Arrays;

public class q7 {

    public static int reverse(int x) {

        /* 15.42%, 23.58%
        if (x > Math.pow(2, 31) - 1 || x < -Math.pow(2, 31)) {
            return 0;
        }

        String input = Integer.toString(x);
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];

        for (int i = 0; i < input.length(); i++) {
            outputArray[outputArray.length - i - 1] = inputArray[i];
        }
        if (x < 0) {
            System.arraycopy(outputArray, 0, outputArray, 1, outputArray.length - 1);
            outputArray[0] = '-';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : outputArray) {
            stringBuilder.append(c);
        }
        double tmp = Double.valueOf(stringBuilder.toString());
        if (tmp > Math.pow(2, 31) - 1 || tmp < -Math.pow(2, 31)) {
            return 0;
        }
        int result = Integer.valueOf(stringBuilder.toString());
        return result;
        */

        //100%,27.47%
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(210));
    }
}
