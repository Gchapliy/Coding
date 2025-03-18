package leetcode;

import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int sum = 0;
        var maxWeightObtained = 0;

        var weights = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        var symbols = s.toCharArray();

        for (var i = symbols.length - 1; i >= 0; i--){
            var symbol = symbols[i];
            var symbolWeight = weights.get(symbol);

            if(symbolWeight < maxWeightObtained){
                sum -= symbolWeight;
            } else {
                sum += symbolWeight;
                maxWeightObtained = symbolWeight;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
