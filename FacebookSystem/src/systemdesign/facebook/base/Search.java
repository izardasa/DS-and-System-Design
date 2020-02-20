package systemdesign.facebook.base;

import java.util.List;

import systemdesign.facebook.impl.Group;
import systemdesign.facebook.impl.Member;
import systemdesign.facebook.impl.Page;
import systemdesign.facebook.impl.Post;

public interface Search {
List<Member> searchMembers(String name);
List<Group> searchGroups(String group);
List<Page> searchPages(String page);
List<Post> searchPosts(String post);
}
