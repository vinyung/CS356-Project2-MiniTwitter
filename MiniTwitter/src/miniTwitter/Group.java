package miniTwitter;
import java.util.Map;

public class Group {//class group is component

	Map<String, Group> numGroup;
	
	private String group;
	//private static final Group instance = new Group();
	
	public Group(String createGroup) {
		this.group = createGroup;
	}
	

//	public static Group getInstace() {
//		return instance;
//	}
	
	public String getGroup() {//returns group
		return group;
	}

	public void setUser(String group) {//puts user in the group
		this.group = group;
	}
	
	public String toString() {//returns group by toString
		return group;
	}
	
	
}
