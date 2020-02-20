package systemdesign.facebook.impl;

import java.util.HashMap;
import java.util.List;

import systemdesign.facebook.base.Search;

public class SearchImpl implements Search{

	private HashMap<String, List<Post>> posts;
	private HashMap<String, List<Member>> members;
	private HashMap<String, List<Page>> pages;
	private HashMap<String, List<Group>> groups;
	
	@Override
	public List<Member> searchMembers(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> searchGroups(String group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Page> searchPages(String page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String post) {
		// TODO Auto-generated method stub
		return null;
	}

}
