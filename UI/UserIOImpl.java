package UI;

import java.util.*;

public class UserIOImpl implements UserIO {
    Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        String stringNumber = scanner.nextLine();
        int number = Integer.parseInt(stringNumber);

        while (number < min || number > max) {

            if (number < min || number > max) {
                System.out.println("Please input the correct number");
                stringNumber = scanner.nextLine();
                number = Integer.parseInt(stringNumber);
            }
        }
        return number;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        return input;
    }
}
