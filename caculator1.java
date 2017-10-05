package Pocket_Gem;
import java.util.*;

/**
 * Created by xiaochen on 10/4/17.
 */
public class caculator1 {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            }
            if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            }
            if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
        }
        return res + sign * num;
    }
}
