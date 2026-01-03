import java.util.*;

public class Team {

    String teamName;
    ArrayList<Developer> developers = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
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
        Developer developer = new Developer("unknown");
        for (Developer developerInList : developers) {
            if (developerInList.getName().equalsIgnoreCase(developerName)) {
                developer = developerInList;
            } else {
                return developer;
            }
        }
        return developer;
    }

    public void printTeamOverview() {
        System.out.println("*========= Overview of Team: " + teamName.toUpperCase() + " =========*\n");
        for (Developer developer : developers) {
            System.out.println("Developer: " + developer.getName());
            System.out.println("Skillset:");
            for (Skill skill : developer.skills) {
                System.out.println(" - " + skill.getName() + " LVL: " + skill.getLevel());
            }
            System.out.println("\n------------------------------\n");
        }
    }
//
//    public TreeMap<Double, Developer> rankDevelopersForSkill(String skillName) {
//        TreeMap<Double, Developer> skillsRankedList = new TreeMap<>();
//
//        for (Developer developer : developers) {
//            double skillLevel = 0;
//            for (Skill skill : developer.skills) {
//                if (skill.getName().equalsIgnoreCase(skillName)) {
//                    skillLevel = skill.getLevel();
//                }
//            }
//            if (!skillsRankedList.containsKey(skillLevel)) {
//                skillsRankedList.put(skillLevel, developer);
//            } else if (skillsRankedList.containsKey(skillLevel)) {
//                while(skillsRankedList.containsKey(skillLevel)) {
//                    skillLevel += 0.01;
//                }
//
//            }
//        }
//        return skillsRankedList;
//    }

    public LinkedHashMap<Developer, Integer> rankDevelopersForSkill(String skillName) {
        ArrayList<Integer> skillsRankedList = new ArrayList<>();
        LinkedHashMap<Developer, Integer> DevelopersRankedBySkill = new LinkedHashMap<>();

        for (int skillLevel = 1; skillLevel <= 10; skillLevel++) {
            skillsRankedList.add(skillLevel);
        }
        Collections.reverse(skillsRankedList);

        for (Integer skillLevel : skillsRankedList) {
            for (Developer developer : developers) {
                for (Skill skill : developer.getSkills()) {
                    if (skill.getName().equalsIgnoreCase(skillName) && skill.getLevel() == skillLevel) {
                        DevelopersRankedBySkill.put(developer, skill.getLevel());
                    }
                }
            }
        }

        return DevelopersRankedBySkill;
    }


    public void bestTopXDevelopersForSkill(String skillName, int amountShown) {
        LinkedHashMap<Developer, Integer> developersRankedList = rankDevelopersForSkill(skillName);
        System.out.println("Top " + amountShown + " list of developers ranked by the skill: " + skillName.toUpperCase() + "\n");
        for (int i = 1; i <= amountShown; i++) {
            String topDeveloperName = developersRankedList.firstEntry().getKey().getName();
            int topDeveloperLVL = developersRankedList.firstEntry().getValue();
            System.out.println(i + ". " + topDeveloperName + "LVL: " + topDeveloperLVL);
            developersRankedList.remove(developersRankedList.firstEntry().getKey());
        }
        System.out.println("==================================");
    }

    public void bestDeveloperForSkill(String skillName) {
        LinkedHashMap<Developer, Integer> developersRankedList = rankDevelopersForSkill(skillName);
        String topDeveloperName = developersRankedList.firstEntry().getKey().getName();
        int topDeveloperLVL = developersRankedList.firstEntry().getValue();
        System.out.println("Most qualified:");
        developersRankedList.keySet().forEach((Developer developer) -> {
            if (topDeveloperLVL == developersRankedList.get(developer)) {
                System.out.println(" - " + developer.getName());
            }
        });

    }

    public void findDevelopersMeetingRequirements(String skillName, int lvlRequirement) {
        LinkedHashMap<Developer, Integer> developersRankedList = rankDevelopersForSkill(skillName);
        System.out.println("List of developers that meet the requirements:");
        System.out.println(("=== ranked by skill level === " + "\n"));
        while (!developersRankedList.isEmpty()) {
            String topDeveloperName = developersRankedList.firstEntry().getKey().getName();
            int topDeveloperLVL = developersRankedList.firstEntry().getValue();
            System.out.println(" - " + topDeveloperName + "LVL: " + topDeveloperLVL);
            developersRankedList.remove(developersRankedList.firstEntry().getKey());
        }
        System.out.println("==================================");
    }
}
