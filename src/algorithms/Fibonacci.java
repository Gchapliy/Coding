package algorithms;

import java.util.Arrays;

/**
 * Realization Fibonacci algorithm following dynamic programming principles
 */
public class Fibonacci {
    public static void main(String[] args)
    {
        int[] result = fib(5);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.stream(result).sum());
    }

    public static int[] fib(int n){
        int[] f = new int[n];
        f[0] = f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }
}
