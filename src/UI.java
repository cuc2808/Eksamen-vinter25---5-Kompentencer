import com.sun.tools.javac.Main;

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

    public String userTeamNameInput() {
        String userInput;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            for (Team team : TeamManager.teams) {
                if (userInput.equalsIgnoreCase(team.teamName)) {
                    return userInput;
                }
            }
            System.out.println("Invalid name, try again.");
        }
    }

    public String userDeveloperNameInput() {
        String userInput;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            for (Team team : TeamManager.teams) {
                for (Developer developer : team.developers) {
                    if (userInput.equalsIgnoreCase(developer.getName())) {
                        return userInput;
                    }
                }
            }
            System.out.println("Invalid name, try again.");
        }
    }

    public String userDeveloperSkillNameInput() {
        String userInput;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
            for (Team team : TeamManager.teams) {
                for (Developer developer : team.developers) {
                    for (Skill skill : developer.skills) {
                        if (userInput.equalsIgnoreCase(skill.getName())) {
                            return userInput;
                        }
                    }
                }
            }
            System.out.println("Invalid name, try again.");
        }
    }

    public int userSkillAmountInput(String skillName) {
        int userInput;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = userIntInput();
            for (Team team : TeamManager.teams) {
                for (Developer developer : team.developers) {
                    for (Skill skill : developer.skills) {
                        if (skillName.equalsIgnoreCase(skill.getName())) {
                            if((skill.getLevel() + userInput) <= 10) {
                                return userInput;
                            }
                        }
                    }
                }
            }
            System.out.println("Invalid number, try again.");
        }
    }

    public int stringToInt(String string) {

        int integer = -1;

        try {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException e) {
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
