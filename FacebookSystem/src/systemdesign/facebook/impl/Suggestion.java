package systemdesign.facebook.impl;


import java.util.Date;
import java.util.List;

public class Suggestion {
private Member from;
private Member to;
private List<Member> suggestedMembers;
private Date suggestedDate;

public boolean acceptSuggestion(int fromMemberId, int suggestedMemberId){return true;}
public boolean declineSuggestion(int fromMemberId, int suggestedMemberId){return true;}
}
