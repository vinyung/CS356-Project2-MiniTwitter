package miniTwitter;
public interface Composite 
{//interface composite
	public void add(User user);//method for adding user 
	public void add(Group group);//method for adding group
	public String getUser();//returns user
	public String getGroup();//returns group
}
