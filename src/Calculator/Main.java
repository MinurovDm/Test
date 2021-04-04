package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner InputData = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String userData = InputData.nextLine();
        int flag = 0;
        if (userData.contains("+"))
            flag = 1;
        else if (userData.contains("-"))
            flag = 2;
        else if (userData.contains("/"))
            flag = 3;
        else if (userData.contains("*"))
            flag = 4;
        else
            System.exit(0);
        printSolve(userData, flag);
    }

    static void printSolve(String equation, Integer flag) {
        String romNumbers = "IVXLC";
        if (romNumbers.indexOf(equation.charAt(0)) != -1) {
            if (flag == 1) {
                System.out.println(getSolveRomanianNums(equation.split("\\+"), flag));
            } else if (flag == 2)
                System.out.println(getSolveRomanianNums(equation.split("\\-"), flag));
            else if (flag == 3)
                System.out.println(getSolveRomanianNums(equation.split("/"), flag));
            else if (flag == 4)
                System.out.println(getSolveRomanianNums(equation.split("\\*"), flag));
        } else if (romNumbers.indexOf(equation.charAt(0)) == -1) {
            if (flag == 1)
                System.out.println(getSolveArabicNums(equation.split("\\+"), flag));
            else if (flag == 2)
                System.out.println(getSolveArabicNums(equation.split("\\-"), flag));
            else if (flag == 3)
                System.out.println(getSolveArabicNums(equation.split("\\/"), flag));
            else if (flag == 4)
                System.out.println(getSolveArabicNums(equation.split("\\*"), flag));
        }
    }

    private static int getSolveArabicNums(String[] nums, Integer flag) {
        try {
            int a = Integer.parseInt(nums[0].trim());
            int b = Integer.parseInt(nums[1].trim());
            if ((a <= 0 || b <= 0) || (a > 10 || b > 10)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Одно или оба Ваших числа не удовлетворяют условию. Программа завершает работу.");
            System.exit(0);
        }
        if (flag == 1)
            return Integer.parseInt(nums[0].trim()) + Integer.parseInt(nums[1].trim());
        else if (flag == 2)
            return Integer.parseInt(nums[0].trim()) - Integer.parseInt(nums[1].trim());
        else if (flag == 3)
            return Integer.parseInt(nums[0].trim()) / Integer.parseInt(nums[1].trim());
        else
            return Integer.parseInt(nums[0].trim()) * Integer.parseInt(nums[1].trim());
    }

    private static String getSolveRomanianNums(String[] nums, Integer flag) {
        try {
            int a = romanToArabic(nums[0].trim());
            int b = romanToArabic(nums[1].trim());
            if ((a <= 0 || b <= 0) || (a > 10 || b > 10)) throw new Exception();
        } catch (Exception e) {
            System.out.println("Одно или оба Ваших числа не удовлетворяют условию. Программа завершает работу.");
            System.exit(0);
        }
        if (flag == 1)
            return arabToRoman(romanToArabic(nums[0].trim()) + romanToArabic(nums[1].trim()));
        else if (flag == 2)
            return arabToRoman(romanToArabic(nums[0].trim()) - romanToArabic(nums[1].trim()));
        else if (flag == 3)
            return arabToRoman(romanToArabic(nums[0].trim()) / romanToArabic(nums[1].trim()));
        else
            return arabToRoman(romanToArabic(nums[0].trim()) * romanToArabic(nums[1].trim()));
    }

    private static String arabToRoman(int num) {
        String[] c = {"", "C"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String hundreds = c[Math.abs(num) / 100];
        String tens = x[(Math.abs(num) % 100) / 10];
        String ones = i[Math.abs(num) % 10];
        if (num < 0)
            return "-" + hundreds + tens + ones;
        else if (hundreds.equals("") && tens.equals("") && ones.equals(""))
            return "0";
        else
            return hundreds + tens + ones;
    }

    private static int value(char romNum) {
        if (romNum == 'I')
            return 1;
        if (romNum == 'V')
            return 5;
        if (romNum == 'X')
            return 10;
        if (romNum == 'L')
            return 50;
        if (romNum == 'C')
            return 100;
        return -1;
    }

    private static int romanToArabic(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int num1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int num2 = value(str.charAt(i + 1));
                if (num1 >= num2) {
                    res += num1;
                } else {
                    res += num2 - num1;
                }
            } else {
                res += num1;
            }
        }
        return res;
    }
}
