package systemdesign.facebook.impl;

import java.util.Date;
import java.util.List;

public class Group {
	private String name;
	private String desc;
	private Date createdDate;
	private List<Member> members;
	private Member owner;
	public boolean addMember(Member member){return true;}
	public boolean updateDescription(String desc){return true;}
	public boolean removeMember(String memberId){return true;}
	public List<Member> getAllMembers(){return null;}

}
