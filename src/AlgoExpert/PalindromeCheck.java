package AlgoExpert;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str == null || str.length() <= 1) return true;

        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.print(isPalindrome("GeeGGeeG"));
    }
}
