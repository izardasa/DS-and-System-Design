package systemdeisgn.linkedin.impl;

import java.util.Date;
import java.util.List;

public class Group {
private String name;
private Date creationDate;
private Member owner;
private List<Member> members;
private String description;

public boolean addMember(Member member){return true;}
public boolean updateDesciption(String desscription){return true;}


}
