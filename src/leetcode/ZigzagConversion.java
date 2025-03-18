package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        List<StringBuilder> lsb = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lsb.add(new StringBuilder());
        }

        int rowNum = 0;
        int increment = 1;
        for (int i = 0; i < s.length(); i++) {
            lsb.get(rowNum).append(s.charAt(i));
            rowNum += increment;
            if (rowNum == numRows || rowNum < 0) {
                increment *= -1;
                rowNum += increment * 2;
            }

        }

        return lsb.stream().reduce(StringBuilder::append).get().toString();
    }
}
