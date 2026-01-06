import java.util.ArrayList;

public class TeamManager {
    public UI ui = new UI();
    public  static ArrayList<Team> teams = new ArrayList<>();

    public void loadManager() {
        loadTeams();
        showTeams();
        teamMenu();
    }

    public void showTeams() {
        for (Team team : teams) {
            team.printTeamOverview();
        }
    }


    public void loadTeams() {

        Team redVelvets = new Team("Red Velvets");
        teams.add(redVelvets);

        redVelvets.addDeveloper("Jonas");
        redVelvets.developers.get(0).addSkill("GitHub", 7);
        redVelvets.developers.get(0).addSkill("Java", 7);
        redVelvets.developers.get(0).addSkill("SQL", 7);
        redVelvets.developers.get(0).addSkill("IRL Specialist", 7);

        redVelvets.addDeveloper("Christopher");
        redVelvets.developers.get(1).addSkill("GitHub", 2);
        redVelvets.developers.get(1).addSkill("Java", 10);
        redVelvets.developers.get(1).addSkill("SQL", 2);
        redVelvets.developers.get(1).addSkill("IRL Specialist", 10);

        redVelvets.addDeveloper("Arthur");
        redVelvets.developers.get(2).addSkill("GitHub", 10);
        redVelvets.developers.get(2).addSkill("Java", 1);
        redVelvets.developers.get(2).addSkill("SQL", 1);
        redVelvets.developers.get(2).addSkill("IRL Specialist", 10);

        redVelvets.addDeveloper("Benjamin");
        redVelvets.developers.get(3).addSkill("GitHub", 4);
        redVelvets.developers.get(3).addSkill("Java", 8);
        redVelvets.developers.get(3).addSkill("SQL", 10);
        redVelvets.developers.get(3).addSkill("IRL Specialist", 9);

        redVelvets.addDeveloper("Joachim");
        redVelvets.developers.get(4).addSkill("GitHub", 5);
        redVelvets.developers.get(4).addSkill("Java", 1);
        redVelvets.developers.get(4).addSkill("SQL", 5);
        redVelvets.developers.get(4).addSkill("IRL Specialist", 7);

        //==================================================

        Team blueBirds = new Team("Blue Birds");
        teams.add(blueBirds);

        blueBirds.addDeveloper("Mads");
        blueBirds.developers.get(0).addSkill("GitHub", 5);
        blueBirds.developers.get(0).addSkill("Java", 5);
        blueBirds.developers.get(0).addSkill("SQL", 5);
        blueBirds.developers.get(0).addSkill("IRL Specialist", 9);

        blueBirds.addDeveloper("Bertram");
        blueBirds.developers.get(1).addSkill("GitHub", 5);
        blueBirds.developers.get(1).addSkill("Java", 3);
        blueBirds.developers.get(1).addSkill("SQL", 2);
        blueBirds.developers.get(1).addSkill("IRL Specialist", 10);

        blueBirds.addDeveloper("Patrick");
        blueBirds.developers.get(2).addSkill("GitHub", 9);
        blueBirds.developers.get(2).addSkill("Java", 9);
        blueBirds.developers.get(2).addSkill("SQL", 4);
        blueBirds.developers.get(2).addSkill("IRL Specialist", 1);

        blueBirds.addDeveloper("Marko");
        blueBirds.developers.get(3).addSkill("GitHub", 4);
        blueBirds.developers.get(3).addSkill("Java", 4);
        blueBirds.developers.get(3).addSkill("SQL", 4);
        blueBirds.developers.get(3).addSkill("IRL Specialist", 4);

        blueBirds.addDeveloper("Emil");
        blueBirds.developers.get(4).addSkill("GitHub", 5);
        blueBirds.developers.get(4).addSkill("Java", 1);
        blueBirds.developers.get(4).addSkill("SQL", 10);
        blueBirds.developers.get(4).addSkill("IRL Specialist", 5);
    }

    public void teamMenu() {

        System.out.println("\n================= Menu ==================\n");

        System.out.println("1. Update Developer skills");
        System.out.println("2. Add Developer");
        System.out.println("3. Remove Developer");
        System.out.println("4. List Best Developers For a Certain Skill");
        System.out.println("5. List Top X Developers For a Certain Skill");
        System.out.println("6. List All Developers That Meet A Certain Skill And Level");
        System.out.println("7. Close Application");
        while(true){

            int input = ui.userIntInput();
            if(input == 1) {
                updateDeveloperMenu();
                teamMenu();
            } else if (input == 2) {
                addDeveloperMenu();
                teamMenu();
            } else if (input == 3) {
                removeMenu();
                teamMenu();
            } else if (input == 4) {
                bestFromSkill();
                teamMenu();
            } else if (input == 5) {
                topXListFromSkill();
                teamMenu();
            } else if (input == 6) {
                meetASkillMenu();
                teamMenu();
            } else if (input == 7){
                closeApp();
                return;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }

    public void updateDeveloperMenu(){
        System.out.println("In what team is the developer you want to update?");
        String input = ui.userTeamNameInput();
        System.out.println("What is the developer's name?");
        String nameInput = ui.userDeveloperNameInput();
        System.out.println("What's the skill you want to change?");
        String skillNameInput = ui.userDeveloperSkillNameInput();
        System.out.println("How many levels do you want to add?");
        int amount = ui.userSkillAmountInput(skillNameInput);
        for (Team team : teams) {
            if (team.teamName.equalsIgnoreCase(input)) {
                for (Developer developer : team.developers) {
                    if (developer.getName().equalsIgnoreCase(nameInput)) {
                        developer.updateSkillLevel(skillNameInput,amount);
                    }
                }
            }
        }
        System.out.println("Skill Level Updated.");
        ui.sleep(2000);
        showTeams();
    }

    public void addDeveloperMenu() {
        System.out.println("In what team do you want to add the developer?");
        String input = ui.userTeamNameInput();
        System.out.println("What is the developer's name?");
        String nameInput = ui.userStringInput();
        for (Team team : teams) {
            if (team.teamName.equalsIgnoreCase(input)) {
                team.addDeveloper(nameInput);
                for (Developer developer : team.developers) {
                    if (developer.getName().equalsIgnoreCase(nameInput)) {
                        developer.addSkill("GitHub",0);
                        developer.addSkill("Java",0);
                        developer.addSkill("SQL",0);
                        developer.addSkill("IRL Specialist",0);
                    }
                }
            }
        }

        System.out.println("Developer Added.");
        ui.sleep(2000);
        showTeams();
    }

    public void removeMenu() {
        System.out.println("What developer do you want removed?");
        String name = ui.userDeveloperNameInput();
        for (Team team : teams) {
            team.removeDeveloper(name);
        }
        System.out.println("Developer removed.");
        ui.sleep(2000);
        showTeams();
    }

    public void bestFromSkill(){
        System.out.println("What skill do you wanna check out?");
        String skillName = ui.userDeveloperSkillNameInput();
        for (Team team : teams) {
            System.out.println("========== From team " + team.teamName + " ==========");
            team.bestDeveloperForSkill(skillName);
        }
        ui.sleep(2000);
        showTeams();
    }

    public void topXListFromSkill(){
        System.out.println("What skill do you wanna check out?");
        String skillName = ui.userDeveloperSkillNameInput();
        System.out.println("How many developers do you want to see?");
        int topX = ui.userIntInput();
        System.out.println("==========================================");
        for (Team team : teams) {
            System.out.println("========== From team " + team.teamName + " ==========");
            team.bestTopXDevelopersForSkill(skillName, topX);
        }
        ui.sleep(2000);
        showTeams();
    }

    public void meetASkillMenu(){
        System.out.println("What skill do you wanna check out?");
        String skillName = ui.userDeveloperSkillNameInput();
        System.out.println("How high does the level have to be?");
        int x = ui.userSkillAmountInput(skillName);
        System.out.println("==========================================");
        for (Team team : teams) {
            System.out.println("========= From team " + team.teamName + " ==========");
            team.findDevelopersMeetingRequirements(skillName, x);
        }
        ui.sleep(2000);
        showTeams();
    }

    public void closeApp(){
        System.out.println("Closing application...");
        ui.sleep(2000);
        System.out.println("Have a nice Day! :D");
    }
}
