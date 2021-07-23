package Q1;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operator;
        int numberOne;
        int numberTwo;
        int result;

        System.out.println("Entre com a operação a ser realizada (+, - ou *):");
        operator = input.next();

        System.out.println("Entre com o primeiro número:");
        numberOne = input.nextInt();

        System.out.println("Entre com o segundo número:");
        numberTwo = input.nextInt();

        switch (operator) {
            case ("+"):
                result = numberOne + numberTwo;
                System.out.println("O resultado da operação é: " + result);
                break;

            case ("-"):
                result = numberOne - numberTwo;
                System.out.println("O resultado da operação é: " + result);
                break;

            case ("*"):
                result = numberOne * numberTwo;
                System.out.println("O resultado da operação é: " + result);
                break;

            default:
                System.out.println("Operação inválida");
        }
    }
}
