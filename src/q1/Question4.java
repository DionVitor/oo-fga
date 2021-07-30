package q1;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int number = 0;

        while (number >= 0) {
            sum += number;

            System.out.println("Digite um numero positivo para ser somado ou negativo para sair:");
            number = input.nextInt();
        }

        System.out.println("A soma é: " + sum);
    }
}
