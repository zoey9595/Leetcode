package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q20 {

    static final char OPEN_PARENTHESE = '(';
    static final char CLOSE_PARENTHESE = ')';
    static final char OPEN_BRACKET = '[';
    static final char CLOSE_BRACKET = ']';
    static final char OPEN_CURLY = '{';
    static final char CLOSE_CURLY = '}';

    public static boolean isValid(String s) {

        /* Solution 1:
        Map<Character, Character> closing = new HashMap<>();
        closing.put('[', ']');
        closing.put('{', '}');
        closing.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char br = s.charAt(i);
            if (br =='[' || br == '{' || br == '(')
                stack.push(br);
            else if (stack.isEmpty() || (br != closing.get(stack.pop())))
                return false;
        }
        return stack.isEmpty();*/

        // Solution 2:
        if (s == null || s.isEmpty()) {
            return true;
        }

        // build a stack
        char[] stack = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (c == OPEN_PARENTHESE || c == OPEN_BRACKET || c == OPEN_CURLY) {
                stack[top++] = c;
            } else {
                if (top == 0) {
                    return false;
                }
                // pop the top
                final char open = stack[--top];
                if (c == CLOSE_PARENTHESE && open != OPEN_PARENTHESE) {
                    return false;
                }
                if (c == CLOSE_BRACKET && open != OPEN_BRACKET) {
                    return false;
                }
                if (c == CLOSE_CURLY && open != OPEN_CURLY) {
                    return false;
                }
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([])"));

    }


}
