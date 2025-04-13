package LeetCode.ease;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void isPalindromeString() {
        assertTrue(PalindromeNumber.isPalindromeString(121), "121 is a palindrome");

        assertFalse(PalindromeNumber.isPalindromeString(10), "10 is not a palindrome");

        assertFalse(PalindromeNumber.isPalindromeString(-121), "-121 is not a palindrome");
    }

    @Test
    void isPalindromeInteger() {
        assertTrue(PalindromeNumber.isPalindromeString(121), "121 is a palindrome");

        assertFalse(PalindromeNumber.isPalindromeString(10), "10 is not a palindrome");

        assertFalse(PalindromeNumber.isPalindromeString(-121), "-121 is not a palindrome");

    }
}