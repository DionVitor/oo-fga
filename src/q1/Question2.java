package q1;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        int day;
        int month;
        int year;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o dia:\n");
        day = input.nextInt();

        System.out.print("Digite o mes:\n");
        month = input.nextInt();

        System.out.print("Digite o ano:\n");
        year = input.nextInt();

        if(month >= 1 && month <= 12) {
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10|| month == 12) {
                if(day >= 1 && day <= 31) {
                    System.out.println("Data Válida. A data digitada foi: " + day + "/" + month + "/" + year);
                } else {
                    System.out.println("Data Inválida");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if(day >= 1 && day <= 30) {
                    System.out.println("Data Válida. A data digitada foi: " + day + "/" + month + "/" + year);
                } else {
                    System.out.println("Data Inválida");
                }
            } else if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (day >= 1 && day <= 29) {
                        System.out.println("Data Válida. A data digitada foi: " + day + "/" + month + "/" + year);
                    } else {
                        System.out.println("Data Inválida");
                    }
                } else {
                    if (day >=1 && day <= 28) {
                        System.out.println("Data Válida. A data digitada foi: " + day + "/" + month + "/" + year);
                    } else {
                        System.out.println("Data Inválida");
                    }
                }
            }
        } else {
            System.out.println("Data Inválida");
        }
    }
}