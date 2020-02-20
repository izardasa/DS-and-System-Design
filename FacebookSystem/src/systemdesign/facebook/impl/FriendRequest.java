package systemdesign.facebook.impl;


import java.util.Date;

import systemdesign.facebook.base.FriendRequestStatus;

public class FriendRequest {
private Member to;
private Member sender;
private Date requestedDate;
private FriendRequestStatus status;

public boolean acceptFriendRequest(int fromMemberId, int toMemberId){return true;}
public boolean rejectFriendRequest(int fromMemberId, int toMemberId){return true;}
}
