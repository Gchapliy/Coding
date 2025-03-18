package leetcode;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hun = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thn = new String[]{"", "M", "MM", "MMM"};

        return thn[num / 1000] + hun[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }

    public static void main(String[] args) {
        System.out.println("MMMDCCXLIX -> " + intToRoman(3749));
        System.out.println("LVIII -> " + intToRoman(58));
        System.out.println("MCMXCIV -> " + intToRoman(1994));
    }
}
