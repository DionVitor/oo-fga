package Q1;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o caracter a ser verificado:");
        char character = input.next().charAt(0);

        System.out.println((int) character >= 48 && (int) character <= 57);

    }
}
