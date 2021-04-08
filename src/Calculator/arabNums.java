package Calculator;

import static java.lang.System.*;

public class arabNums {
    private final String num1;
    private final String num2;
    private final String sing;

    public arabNums(String number1, String number2, String sing) {
        this.num1 = number1;
        this.num2 = number2;
        this.sing = sing;
    }

    public int decision() {
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            if ((a <= 0 || b <= 0) || (a > 10 || b > 10)) throw new Exception();
        } catch (NumberFormatException e) {
            out.println(e);
            exit(0);
        } catch (Exception e) {
            out.println("Неверный диапазон чисел. Программа завершает работу.");
            exit(0);
        }
        switch (sing) {
            case "+":
                return Integer.parseInt(num1) + Integer.parseInt(num2);
            case "-":
                return Integer.parseInt(num1) - Integer.parseInt(num2);
            case "/":
                return Integer.parseInt(num1) / Integer.parseInt(num2);
            case "*":
                return Integer.parseInt(num1) * Integer.parseInt(num2);
            default:
                out.println("Неизвестный арифметический знак");
                return -1;
        }
    }
}
