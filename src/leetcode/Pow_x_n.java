package leetcode;

public class Pow_x_n {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(0.44528, 0));
        System.out.println(myPow(0.00001, 2147483647));
    }
    public static double myPow(double x, int n) {
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }

        double pow = 1;

        while (n != 0) {
            if((n & 1) != 0) {
                pow *= x;
            }

            x *= x;
            n >>>= 1;
        }

        return pow;
    }
}
