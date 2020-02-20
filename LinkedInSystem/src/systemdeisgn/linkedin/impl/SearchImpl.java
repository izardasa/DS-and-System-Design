package systemdeisgn.linkedin.impl;

import java.util.HashMap;
import java.util.List;

import systemdeisgn.linkedin.base.Search;

public class SearchImpl implements Search{

	private HashMap<String, List<Job>> jobTitles;
	private HashMap<String,List<Member>> memberNames;
	private HashMap<String, List<Company>> companyNames;
	@Override
	public List<Job> searchJobs(String job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> searchCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> seachMembers(String member) {
		// TODO Auto-generated method stub
		return null;
	}

}
