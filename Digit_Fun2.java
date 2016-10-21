import java.util.Scanner;

public class Digit_Fun2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str = input.nextLine();
            int counter = 1;
            while (stringToInt(str) != 1) {
                str = String.valueOf(str.length());
                counter++;
            }
            System.out.println(counter);
        }
    }

    private static int stringToInt(String str) {
        char[] temp = str.toCharArray();
        int value = 0;
        for (int i = 0; i < temp.length; i++) {
            int tempIdPart = (int) temp[i] - 48;
            value = value + tempIdPart * (int) (Math.pow(10, temp.length - i - 1));
        }
        return value;
    }
}
