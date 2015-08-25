package miniTwitter;

import java.util.*;

public class User extends Observable implements Observer {

	private String user;
	private List<User> followers = new ArrayList<User>();
	private List<User> following = new ArrayList<User>();
	private List<String> newsFeed = new ArrayList<String>();
	private List<String> tweets = new ArrayList<String>();
	
//	private static final User instance = new User()
	
//	public User() {
//		// empty constructor
//	}
	

	
	public void followUser(User user) {//method followUser, adds the user to your following list
		User follow = user;
		this.following.add(follow);//follows the user used as a parameter
		notifyObservers(follow);//notifies observers of the user
		followers.add(follow);//adds you to their followers
	}
	
	public void writeTweet(String tweet) {//method to write a tweet
		tweets.add(tweet);//adds the tweet to the tweets list
		notifyObservers(tweet);//notifies observers of the tweet
		updateTweet(tweet);//updates the tweet
	}

	@Override
	public void update(String user, String tweet) {

	}

//	public static User getInstace() {
//		return instance;
//	}
	
	public String getUser() {//returns the user
		return user;
	}

	public void setUser(String user) {//sets user to string
		this.user = user;
	}
	
	public String toString() {// to string method
		return user;
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}

	@Override
	public void updateTweet(String tweet) {
		// TODO Auto-generated method stub
		
	}

}
