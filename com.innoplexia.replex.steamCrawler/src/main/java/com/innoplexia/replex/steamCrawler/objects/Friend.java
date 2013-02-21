package com.innoplexia.replex.steamCrawler.objects;


public class Friend
{
	private String friendId;

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + "]";
	}
	
}
