package Easy;

import java.util.HashMap;

public class q13 {

    public static int romanToInt(String s) {

        /* My solution: 7ms(41.99%), 36.2MB(99.94%)
        HashMap<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

        int sum = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            sum += table.get(c);
        }
        if (s.contains("IV")) sum -= 2;
        if (s.contains("IX")) sum -= 2;
        if (s.contains("XL")) sum -= 20;
        if (s.contains("XC")) sum -= 20;
        if (s.contains("CD")) sum -= 200;
        if (s.contains("CM")) sum -= 200;

        return sum;*/

        // Sample solution: 3ms(100%), 37MB(99.91%)
        char[] c = s.toCharArray();
        int num = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'I') {
                if (i < c.length - 1 && c[i + 1] == 'V') {
                    num += 4;
                    i++;
                    continue;
                } else if (i < c.length - 1 && c[i + 1] == 'X') {
                    num += 9;
                    i++;
                    continue;
                } else {
                    num += 1;
                }
            } else if (c[i] == 'X') {
                if (i < c.length - 1 && c[i + 1] == 'L') {
                    num += 40;
                    i++;
                    continue;
                } else if (i < c.length - 1 && c[i + 1] == 'C') {
                    num += 90;
                    i++;
                    continue;
                } else
                    num += 10;
            } else if (c[i] == 'C') {
                if (i < c.length - 1 && c[i + 1] == 'D') {
                    num += 400;
                    i++;
                    continue;
                } else if (i < c.length - 1 && c[i + 1] == 'M') {
                    num += 900;
                    i++;
                    continue;
                } else {
                    num += 100;
                }
            } else if (c[i] == 'V')
                num += 5;
            else if (c[i] == 'L')
                num += 50;
            else if (c[i] == 'D')
                num += 500;
            else if (c[i] == 'M')
                num += 1000;
            else {
                System.out.println("Incorrect character");
                return -1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
