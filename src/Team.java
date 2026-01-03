import java.util.ArrayList;
import java.util.TreeMap;

public class Team {

    String teamName;
    ArrayList<Developer> developers = new ArrayList<>();

    public Team(String teamName, ArrayList<Developer> developers) {
        this.teamName = teamName;
        this.developers = developers;
    }

    public void addDeveloper(String developerName) {
        Developer developer = new Developer(developerName);

        while (true) {
            if (findDeveloper(developerName).getName().equalsIgnoreCase("unknown")) {
                developers.add(developer);
                return;
            } else {
                System.out.println("That developer already exist.");
            }
        }
    }

    public void removeDeveloper(String developerName) {
        Developer developer = findDeveloper(developerName);

        while (true) {
            if (developers.contains(developer)) {
                developers.remove(developer);
                return;
            } else {
                System.out.println("That developer doesn't exist.");
            }
        }
    }

    public Developer findDeveloper(String developerName) {
        Developer developer = null;
        for (Developer developerInList : developers) {
            if (developerInList.getName().equalsIgnoreCase(developerName)) {
                developer = developerInList;
            } else {
                return new Developer("unknown");
            }
        }
        return developer;
    }

    public void printTeamOverview() {

    }

    public TreeMap<Integer,Developer> rankDevelopersForSkill(String skillName) {
        TreeMap<Integer,Developer> skillsRankedList = new TreeMap<>();

        for (Developer developer : developers) {
            int skillLevel = 0;
            for (Skill skill : developer.skills) {
                if(skill.getName().equalsIgnoreCase(skillName)) {
                    skillLevel = skill.getLevel();
                }
            }
            skillsRankedList.put(skillLevel,developer);
        }
        System.out.println();
    }

    public ArrayList<Developer> findDevelopersMeetingRequirements() {

        return null;
    }
}
