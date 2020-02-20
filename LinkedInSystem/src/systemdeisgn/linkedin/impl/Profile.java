package systemdeisgn.linkedin.impl;

import java.util.List;

public class Profile {
private List<Skill> skills;
private List<Education> educations;
private List<Experience> experience;
private List<Achivement> achivements;
private List<Recommendation> recommendations;
private String summary;
private List<Stat> stats;
public boolean addSkill(Skill skill){return true;}
public boolean addEducation(Education education){return true;}
public boolean addExperience(Experience experience){return true;}
public boolean addRecommendation(Recommendation recommendation){return true;}
public boolean addAchivement(Achivement achivement){return true;}
}
