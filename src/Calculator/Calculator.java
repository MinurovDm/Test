package Calculator;


public class Calculator {
    public static void main(String[] args) {
        while (true){
            System.out.println("Введите выражение: ");
            inputData data = new inputData();
            if (data.ArabOrRoman()) {
                System.out.println(new romanNums(data.getNumber1(), data.getNumber2(), data.getSign()).desicion());
            }
            else {
                System.out.println(new arabNums(data.getNumber1(), data.getNumber2(), data.getSign()).decision());
            }
        }
    }
}

