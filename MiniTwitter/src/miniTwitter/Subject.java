package miniTwitter;
import java.util.*;
import miniTwitter.Observer;
public abstract class Subject {//subject used in design pattern
	
	private String user;
	private String tweet;
	
	private List<Observer> obs = new ArrayList<Observer>();
	
	public void attach(Observer observer) {//attach makes it so the observer is added
		obs.add(observer);
	}
	
	public void detach(Observer observer) {//removes observer
		obs.remove(observer);
	}
	
	public void notifyObservers() {//notifies the observers of user tweets
		for(Observer o : obs) {
			o.update(user, tweet);
		}
	}
	
}
