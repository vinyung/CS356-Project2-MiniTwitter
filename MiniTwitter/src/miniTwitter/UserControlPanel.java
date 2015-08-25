package miniTwitter;
//imports all tools needed for gui
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import miniTwitter.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
import java.awt.SystemColor;
@SuppressWarnings("serial")
public class UserControlPanel extends JFrame
{

	private JPanel contentPane;
	private User user;
	public static int tweetCount;//integer to keep track of tweets, is static
//launches the application
	public static void main(String[] args)
	{
		//creation of a new user control panel
	}
		
	public void run() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					UserControlPanel frame = new UserControlPanel();//creates new control panel, if there is an exception it prints location
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public UserControlPanel(User user)
	{//constructor
		this.user = user;
	}
	
//creates the frame
	public UserControlPanel() 
	{
		setBackground(Color.WHITE);
		setBounds(100, 100, 465, 420);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);//sets dimensions for panel and creates content
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();//creates two new text areas for user and newsfeed
		JTextArea textArea_1 = new JTextArea();
		
		textArea.setBounds(15, 20, 200, 35);//sets bounds for 1st text area, where user inputs user to follow
		contentPane.add(textArea);//adds text area to gui
		
		DefaultListModel follow;//creates default list to keep track of users you are following it is called user
		follow = new DefaultListModel();// creates new default list model
		JList list = new JList(follow);//connects it to the jlist
		follow.addElement("Currently Following");//shows current users followed blank initially
		list.setBounds(10, 70, 430, 90);//sets bounds of list
		contentPane.add(list);//adds it to the content pane aka gui
		
		JButton followUser = new JButton("Follow User");//new button to follow user
		followUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("You are now following " + textArea.getText());//prints out message and user you are following
				follow.addElement(textArea.getText());//adds text to the list of people you are following			
			}
		});
		followUser.setBounds(235, 10, 205, 35);//sets bounds for the button
		contentPane.add(followUser);//adds button to gui
		
		textArea_1.setBounds(15, 175, 240, 50);//sets bounds for second text area
		contentPane.add(textArea_1);//adds second text area to gui
		
		JList<String> tweets = new JList<String>();//creates new list tweets
		
		DefaultListModel tweet;//declares default list model tweet
		tweet = new DefaultListModel();//creates object
		JList list_1 = new JList(tweet);//sets the list to the default model 
		tweet.addElement("News Feed");//adds news feed as first entry
		list_1.setBounds(10, 235, 430, 135);//sets bounds for the list
		contentPane.add(list_1);//adds newsfeed to the gui
		
		textArea_1.setBounds(15, 175, 240, 50);//sets bounds of textArea
		contentPane.add(textArea_1);//adds text area to gui
		
		JButton btnTweet = new JButton("Post Tweet");//button to post tweet
		btnTweet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Tweet posted");//prints out confirmation message
				tweet.addElement(textArea_1.getText());//adds tweet to newsfeed
				tweetCount++;//increments tweet counter
			}
		});
		btnTweet.setBounds(274, 170, 163, 45);//sets bounds of tweet button
		contentPane.add(btnTweet);//adds tweet button to gui
		
		
		textArea.addContainerListener(new ContainerAdapter()
		{//overide method for container listener
			@Override
			public void componentAdded(ContainerEvent arg0){}
		});
	}
	
	public int getTweetCount()//method to return tweet count
	{
		return tweetCount;//returns tweet count
	}
}
