package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/4/17.
 */
public class caculator2 {

    //Stack
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i != s.length() - 1) continue;
            }

            if (sign == '+') {
                stack.push(num);
            } else if (sign == '-') {
                stack.push(-num);
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
            } else if (sign == '/') {
                stack.push(stack.pop() / num);
            }
            num = 0;
            sign = c;
        }
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

    // O(1) space
    public int calculateO1(String s) {
        s = s.trim();
        int res = 0, num = 0, pre = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i != s.length() - 1) continue;
            }

            if (sign == '+') {
                res += pre;
                pre = num;
            } else if (sign == '-') {
                res += pre;
                pre = -num;
            } else if (sign == '*') {
                pre = pre * num;
            } else if (sign == '/') {
                pre = pre / num;
            }
            num = 0;
            sign = c;
        }
        return res;
    }

    // Add ^

}
