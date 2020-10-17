package Easy;

public class q14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        /* My solution: 2ms(22.27%), 38.6MB(60.56%)

        int[] ints = new int[strs.length];
        int k = 0;
        int length = strs[0].length();
        for (String s : strs) {
            if (s.equals("")) return "";
            ints[k] = s.length();
            if (ints[k] < length) length = ints[k];
        }

        String out = "";
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].substring(0, i).equals(strs[0].substring(0, i))) {
                    return out;
                }
            }
            out = strs[0].substring(0, i);
        }
        return out;*/

        /* Sample solution 1: 0ms(100%), 36.7MB(99.65%)

        // Find the shortest String
        int shortest = 0;
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int curLen = strs[i].length();
            if (curLen < len) {
                len = curLen;
                shortest = i;
            }
        }
        // Find the longest common prefix
        String sub = strs[shortest];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                sub = sub.substring(0, sub.length() - 1);
            }
        }
        return sub;*/

        // Sample solution 2: 0ms(100%), 37.7MB(84.85%)
        // Only need to compare the shortest string and the longest string
        String min = strs[0];
        String max = strs[0];
        for (String current : strs) {
            if (current.compareTo(max) > 0) {
                max = current;
            } else if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        int num = 0;
        for (int i = 0; i < min.length() && i < max.length(); i++) {
            if (min.charAt(i) != max.charAt(i)) {
                break;
            }
            num++;
        }
        return min.substring(0, num);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "a"}));


    }
}
