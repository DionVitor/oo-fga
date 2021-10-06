package introduction;

public class SwitchCase {
    public static void main(String[] args) {
        int number = 2;
        String nameNumber;

        switch (number) {
            case 1:
                nameNumber = "One";
                break;

            case 2:
                nameNumber = "Two";
                break;

            default:
                nameNumber = "Error";
        }

        System.out.println(nameNumber);

        int other_number = 10;

        switch (other_number) {
            case 1:
                nameNumber = "One";
                break;

            case 2:
                nameNumber = "Two";
                break;

            default:
                nameNumber = "Error";
        }

        System.out.println(nameNumber);
    }
}
