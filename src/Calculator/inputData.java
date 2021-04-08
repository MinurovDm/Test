package Calculator;

import java.util.Scanner;

public class inputData {
    Scanner scanner = new Scanner(System.in);
    private final String expression = scanner.nextLine();

    public inputData() {

    }

    public String getNumber1() {
        return expression.split(" ")[0];
    }

    public String getNumber2() {
        return expression.split(" ")[2];
    }

    public String getSign() {
        return expression.split(" ")[1];
    }

    public boolean ArabOrRoman() {
        String romNum = "IVXLC";
        return ((romNum.indexOf(getNumber1().charAt(0)) != -1) && (romNum.indexOf(getNumber2().charAt(0)) != -1));
    }
}
