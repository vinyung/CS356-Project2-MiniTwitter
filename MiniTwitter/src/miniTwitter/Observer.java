package miniTwitter;

public interface Observer {
	
	public void update(String user, String tweet);//updates user with tweet
	public void updateTweet(String tweet);//updates tweet
	
}
