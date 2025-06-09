package com.skills;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import src.main.java.com.skills.BalancedParentheses;

/**
 * Created by sylvester
 * Email: musyokisyl81@gmail.com
 * Date: 09/06/2025
 * Time: 16:57
 */

public class BalancedParenthesesTest {
    
    @Test
    public void testBalancedParentheses1() {
        assertTrue(BalancedParentheses.isBalanced("([])[]({})"));
    }

    @Test
    public void testBalancedParentheses2() {
        assertFalse(BalancedParentheses.isBalanced("([)]"));
    }

    @Test
    public void testBalancedParentheses3() {
        assertFalse(BalancedParentheses.isBalanced("((()"));
    }

    @Test
    public void testBalancedParentheses4() {
        assertTrue(BalancedParentheses.isBalanced("{[()]}"));
    }

    @Test
    public void testBalancedParentheses5() {
        assertFalse(BalancedParentheses.isBalanced("{[)()]}"));
    }

    @Test
    public void testBalancedParentheses6() {
        assertTrue(BalancedParentheses.isBalanced("()()()"));
    }

    @Test
    public void testBalancedParentheses7() {
        assertTrue(BalancedParentheses.isBalanced("({}[]){}[]()[]{[()]}"));
    }
}
