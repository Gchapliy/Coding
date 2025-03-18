package leetcode;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 10 && x >= 0) return true;
        if (x < 0) return false;
        if (x % 10 == 0) return false;

        int back = 0;
        int xCopy = x;
        int indx = 10;

        while (xCopy > 0) {
            back *= indx;
            back += xCopy % 10;
            xCopy /= 10;
        }

        return back == x;
    }
}
