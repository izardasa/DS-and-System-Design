package systemdeisgn.linkedin.base;

import java.util.List;

import systemdeisgn.linkedin.impl.Group;
import systemdeisgn.linkedin.impl.Job;
import systemdeisgn.linkedin.impl.Member;

public interface Search {
List<Job> searchJobs(String job);
List<Group> searchCompany(String company);
List<Member> seachMembers(String member);
}
