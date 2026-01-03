import java.util.ArrayList;

public class TeamManager {

    public TeamManager() {
        loadTeams();


    }


    public void loadTeams() {

        Team redVelvets = new Team("Red Velvets");

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

        redVelvets.printTeamOverview();

        //==================================================

        Team blueBirds = new Team("Blue Birds");

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

        blueBirds.printTeamOverview();

    }

    public void team
}
