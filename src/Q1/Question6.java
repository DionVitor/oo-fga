package Q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();

        System.out.println("Entre com o primeiro numero:");
        numbers.add(input.nextInt());

        System.out.println("Entre com o segundo numero:");
        numbers.add(input.nextInt());

        System.out.println("Entre com o terceiro numero:");
        numbers.add(input.nextInt());

        System.out.println("Entre com o quarto numero:");
        numbers.add(input.nextInt());

        System.out.println("Entre com o quinto numero:");
        numbers.add(input.nextInt());

        int indexLoop = 0;
        int BiggestNumber = 0;

        for (int number : numbers) {
            if (indexLoop == 0) {
                BiggestNumber = number;
                indexLoop++;
            } else if (number > BiggestNumber) {
                BiggestNumber = number;
            }
        }

        System.out.println(BiggestNumber);
    }
}
