package systemdeisgn.linkedin.impl;

import java.security.acl.Group;
import java.util.Date;
import java.util.List;

public class Member extends Person{
private Date dateOfMembership;
private List<Member> memberFollows;
private List<Company> companyFollows;
private List<Group> groupFollows;
private List<Member> connectionInvitations;
private List<Member> recommendations;

private Profile profile;

public boolean createPost(Post post){return true;}
public boolean makeComment(Comment comment){return true;}
public boolean sendConnectionInvitation(ConnectionInvitation invivation){return true;}
}
