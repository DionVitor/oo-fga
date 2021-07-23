package introduction;

public class WhileLoops {
    public static void main(String[] args) {
        int number = 10;

        while (number > 0) {
            System.out.print(number + " ");
            number--;
        }

        int other_number = 20;

        do {
            System.out.println("Initial action.");
        } while (other_number > 30);

    }
}
