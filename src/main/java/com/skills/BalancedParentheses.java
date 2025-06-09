package src.main.java.com.skills;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 16:08
 */
public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        //Check if string is null/empty - is it balanced?
        if(s == null || s.isEmpty()) return true;
        //Exit if string had odd length
        if(s.length() % 2 != 0) return false;

        //Loop through the strings char
        //If Character is an opening bracket, push to stack
        //If not, it means it is a closing bracket
        //check if stack is empty or if the closing bracket matches the top of the stack
        //if true, the string is balanced.
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(isOpeningTerm(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || !isMatching(stack.pop(),c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char openingTerm, char closingTerm) {
        return (openingTerm=='(' && closingTerm==')') || (openingTerm=='{' && closingTerm=='}') || (openingTerm=='[' && closingTerm==']');
    }

    private static boolean isOpeningTerm(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
