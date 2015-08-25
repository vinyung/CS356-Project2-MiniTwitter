package miniTwitter;//class visitor 
public interface Visitor 
{
	public int visitUser(User user);//visits user entered 
	public int visitGroup(Group group);//visits group entered
}
