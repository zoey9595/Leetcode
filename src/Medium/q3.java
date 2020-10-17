package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class q3 {

    public static void main(String[] args) {
        q3 q3 = new q3();
        System.out.println(q3.lengthOfLongestSubstring("abcabcbb"));
    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1) {
//            return 1;
//        }
//        char[] chars = s.toCharArray();
//        int max = 0;
//        int count = 0;
//        int i = 0;
//        HashSet<Character> hashSet = new HashSet<>();
//        while (i < chars.length) {
//            if (!hashSet.contains(chars[i])) {
//                hashSet.add(chars[i]);
//                if (i == chars.length - 1 && hashSet.size() > max) {
//                    return hashSet.size();
//                }
//                i++;
//            } else {
//                if (hashSet.size() > max) {
//                    max = hashSet.size();
//                }
//                hashSet.clear();
//                count++;
//                i = count;
//            }
//        }
//        return max;
//    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int n = s.length();
        // 右指针初始值-1，结果ans为0
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            // i作为左指针，只要不是0，就把前一个字符移出set
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            // 当右指针不过界
            while (rk + 1 < n && !hashSet.contains(s.charAt(rk + 1))) {
                hashSet.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
