package introduction;

public class ForLoops {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        // for loop common
        for (int index=0; index < numbers.length; index++) {
            System.out.println(numbers[index]);
        }

        System.out.println();

        // for each loop - iterable
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
