package LeetCode.ease;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println("Is Palindrome: " + isPalindromeInteger(x)); // true

        x = -121;
        System.out.println("Is Palindrome: " + isPalindromeInteger(x)); // false

        x = 10;
        System.out.println("Is Palindrome: " + isPalindromeInteger(x)); // false

    }
    public static boolean isPalindromeString(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.reverse().toString().equals(String.valueOf(x));

    }
    public static boolean isPalindromeInteger(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        int orginal = x;

        while(x > 0){
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        return orginal == reversed;
    }
}