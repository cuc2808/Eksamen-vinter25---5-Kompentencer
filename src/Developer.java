import java.util.ArrayList;

public class Developer {

    String name;
    ArrayList<Skill> skills = new ArrayList<>();

    public Developer(String name) {
        this.name = name;
    }

    public void addSkill(String skillName, int skillLevel) {
        Skill skill = new Skill(skillName, skillLevel);
        if (!skills.contains(skill)) {
            skills.add(skill);
        } else {
            System.out.println("Skill already exists.");
        }


    }

    public void updateSkillLevel(String skillName, int amount) {
        Skill skill = null;
        for (Skill skillInList : skills) {
            if (skillInList.getName().equalsIgnoreCase(skillName)) {
                skill = skillInList;
            }
        }
        if (skills.contains(skill)) {
                skill.setLevel(skill.level += amount);
        } else {
            System.out.println("That skill doesn't exist");
        }


    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
