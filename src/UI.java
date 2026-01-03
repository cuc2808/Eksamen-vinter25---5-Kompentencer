import java.util.Scanner;

public class UI {


    public String userStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public boolean userBooleanInput() {
        String userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("Y")) {
                return true;
            } else if (userInput.toUpperCase().equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public int userIntInput() {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = stringToInt(scanner.nextLine());
            if (userInput < 0) {
                System.out.println("Invalid number, please try again.");
            } else {
                return userInput;
            }
        }
    }

    public int stringToInt(String string) {

        int integer = -1;

        try {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            integer = integer;
        }
        return integer;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
