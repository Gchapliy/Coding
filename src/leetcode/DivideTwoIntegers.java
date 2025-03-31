package leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(1, 2));
        System.out.println(divide(5, 2));
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if(dividend < divisor) return 0;
        if(dividend == divisor) return sign;

        int quotient = 0;

        int t;
        for (int i = 30; i >= 0; i--) {
            t = divisor << i;
            if ((t == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(t)) <= dividend) {
                dividend -= (divisor << i);
                if(((long)quotient | (1L << i)) > (long)Integer.MAX_VALUE) {
                    return sign * Integer.MAX_VALUE;
                }
                quotient |= (1 << i);
            }
        }
        if(quotient>=Math.pow(2,30) && sign==1) return Integer.MAX_VALUE;
        if(quotient>=Math.pow(2,30) && sign==-1) return Integer.MIN_VALUE;

        return sign * quotient;
    }
}
