package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myatoi("4193 with words") == 4193);
        System.out.println(myatoi("words and 987") == 0);
        System.out.println(myatoi("   -42") == -42);
        System.out.println(myatoi("-91283472332") == Integer.MIN_VALUE);
        System.out.println(myatoi("3.14159") == 3);
        System.out.println(myatoi(".1") == 0);
        System.out.println(myatoi("  -0012a42") == -12);
        System.out.println(myatoi("+1") == 1);
        System.out.println(myatoi("abs") == 0);
        System.out.println(myatoi("-5-") == -5);
        System.out.println(myatoi("-13+8") == -13);
    }

    public static int myatoi(String s) {
        String[] split = s.trim().split("[\\s.a-zA-Z]");
        if(split.length > 0 && split[0].matches("^[-+]?\\d+.*")) {
            char[] charArray = split[0].toCharArray();
            StringBuilder res = new StringBuilder();
            char [] lib = {'0','1','2','3','4','5','6','7','8','9'};
            char [] signLib = {'+','-'};
            boolean isNum = false;
            for (char ch : charArray) {
                if (Arrays.binarySearch(signLib, ch) > -1) {
                    if (isNum) break;
                    res.append(ch);
                }
                if (Arrays.binarySearch(lib, ch) > -1) {
                    res.append(ch);
                    isNum = true;
                }
            }
            try {
                var num = new BigInteger(res.toString());
                if (num.compareTo(new BigInteger(Integer.toString(Integer.MIN_VALUE))) < 0)
                    return Integer.MIN_VALUE;
                else if (num.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0)
                    return Integer.MAX_VALUE;
                else {

                    return num.intValue();
                }
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }
}


