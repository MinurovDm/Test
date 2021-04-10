package Calculator;


import java.util.HashMap;
import java.util.Map;

public class romanNums {
    private final String num1;
    private final String num2;
    private final String sing;

    public romanNums(String number1, String number2, String sing) {
        this.num1 = number1;
        this.num2 = number2;
        this.sing = sing;
    }

    public String desicion() {
        try{
            int a = romanToArabic(num1);
            int b = romanToArabic(num2);
            if ((a <= 0 || a > 10) || (b <= 0 || b > 10)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Одно или оба числа не удовлетворяют условию. Программа будет завершена!");
            System.exit(0);
        }
        switch (sing) {
            case "+":
                return arabToRoman(romanToArabic(num1) + romanToArabic(num2));
            case "-":
                return arabToRoman(romanToArabic(num1) - romanToArabic(num2));
            case "/":
                return arabToRoman(romanToArabic(num1) / romanToArabic(num2));
            case "*":
                return arabToRoman(romanToArabic(num1) * romanToArabic(num2));
            default:
                return "Неизвестный арифметический знак";
        }
    }
// Стрый вариант
//    private static int romanToArabic(String romNums) {
//        int result = 0;
//        for (int i = 0; i < romNums.length(); i++) {
//            int num1 = value(romNums.charAt(i));
//            if (i + 1 < romNums.length()) {
//                int num2 = value(romNums.charAt(i + 1));
//                if (num1 >= num2) {
//                    result += num1;
//                } else
//                    result += num2 - num1;
//            } else {
//                result += num1;
//            }
//        }
//        return result;
//    }
//
//    private static int value(char romNum) {
//        if (romNum == 'I') return 1;
//        else if (romNum == 'V')
//            return 5;
//        else if (romNum == 'X')
//            return 10;
//        else if (romNum == 'L')
//            return 50;
//        else if (romNum == 'C')
//            return 100;
//        return -1;
//    }
    private static int romanToArabic (String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);

        int result = 0;

        for (int i = 0; i < s.length(); i++){
            if (i < 0 && map.get(s.charAt(i)) > map.get(s.charAt(i -1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i-1));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    private static String arabToRoman(int num) {
        String[] c = {"", "C"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String hundreds = c[Math.abs(num) / 100];
        String tens = x[(Math.abs(num) % 100)/ 10];
        String ones = i[Math.abs(num) % 10];
        if (num < 0) return "-" + hundreds + tens + ones;
        else if (hundreds.equals("") && tens.equals("") && ones.equals("")) return "nulla";
        else return hundreds + tens + ones;
    }
}