package systemdesign.facebook.impl;

import java.util.Date;
import java.util.List;

public class Member extends Person{
private Date registrationDate;

private List<Group> groupFollows;
private List<Member> Memberfollows;
private List<Page> pageFollows;
private List<Member> memberSuggests;
private List<FriendRequest> requestsSent;

public boolean createPost(Post post){return true;}
public boolean sendMessage(Message message){return true;}
public boolean sendFreindRequest(FriendRequest friendRequest){return true;}
}
