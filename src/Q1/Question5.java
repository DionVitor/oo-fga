package Q1;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o numero:");
        number = input.nextInt();

        System.out.print(number % 2 == 0);
    }
}
