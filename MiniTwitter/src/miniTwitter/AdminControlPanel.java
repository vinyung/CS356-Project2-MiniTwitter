package miniTwitter;//																							Vincent Yung
//imports all tools needed for admin control panel
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.EmptyBorder;

import miniTwitter.User;

@SuppressWarnings("serial")
public class AdminControlPanel extends JFrame 
{
	private JPanel controlPanel;
	private User user;
	private DefaultMutableTreeNode node;
	private JTree tree;
	private int tweetCount;
	
// launches the application
	public static void main(String[] args) 
	{
		//run
	}
		
	public void run()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {//run creates a new admin control panel 
				try 
				{
					AdminControlPanel panel = new AdminControlPanel();
					panel.setVisible(true);
				} 
				catch (Exception e) 
				{//if there is an exception it will print where it occured
					e.printStackTrace();
				}
			}
		});
	}

	public AdminControlPanel(User user, DefaultMutableTreeNode node) 
	{
		this.user = user;
		this.node = node;
	}
	
	//creates the frame
	public AdminControlPanel() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//frame closes if you exit
		setBounds(200, 200, 600, 400);//sets the dimensions
		controlPanel = new JPanel();
		controlPanel.setBackground(SystemColor.activeCaption);
		controlPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(controlPanel);
		controlPanel.setLayout(null);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");//creates root for j tree
		DefaultMutableTreeNode user = new DefaultMutableTreeNode("Users");// creates user category
		user.add(new DefaultMutableTreeNode("John"));//adds initial users john bob and steve
		user.add(new DefaultMutableTreeNode("Bob"));
		user.add(new DefaultMutableTreeNode("Steve"));
		
		DefaultMutableTreeNode groups = new DefaultMutableTreeNode("Groups");//creates group category
		groups.add(new DefaultMutableTreeNode("CS 365"));//default cs 365
		root.add(user);//adds user and group to the root of jtree
		root.add(groups);
		tree = new JTree(root);
		tree.setBounds(0, 0, 190, 365);//adds jtree onto the ui
		controlPanel.add(tree);
		
		
		JTextArea userText = new JTextArea();
		JTextArea userText_1 = new JTextArea();
		
		userText.setBounds(200, 25, 165, 35);//sets text area size
		controlPanel.add(userText);//adds text area to gui
		JButton btnNewButton_1 = new JButton("Add User");//creates button so that you can add the user
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println( userText.getText() +" is now added");//displays username is now added
				user.add(new DefaultMutableTreeNode(userText.getText()));//adds the node
				tree.updateUI();//refreshes the tree
			}
		});
		btnNewButton_1.setBounds(390, 25, 165, 35);//sets bounds for the button same size as text
		controlPanel.add(btnNewButton_1);//adds the button to the panel
		
		userText_1.setBounds(200, 85, 165, 35);//sets second text area size
		controlPanel.add(userText_1);//adds text area to gui
		JButton btnNewButton_2 = new JButton("Add Group");//button add group
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Group " +userText_1.getText() + " has been created");//prints out group groupname has been created
				groups.add(new DefaultMutableTreeNode(userText_1.getText()));//creates node and puts it in group tree
				tree.updateUI();//updates the tree
			}
		});
		btnNewButton_2.setBounds(390, 85, 165, 35);//sets bounds for the button same size as text
		controlPanel.add(btnNewButton_2);//adds button to gui
		
		JButton btnNewButton_3 = new JButton("Open User View");//button to open user view
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				UserControlPanel userControlPanel = new UserControlPanel();//creates new user control object and executes it
				userControlPanel.run();//displays user control panel when button is pressed, will display as many times as you press the button
				tweetCount = tweetCount + userControlPanel.getTweetCount();
				
			}
		});
		btnNewButton_3.setBounds(200, 145, 375, 50);//sets size of new button
		controlPanel.add(btnNewButton_3);//adds button to gui
		
		JButton btnNewButton_5 = new JButton("Show User Total");//button that says show user total
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("User count is " + user.getChildCount());//traverses the tree and prints out the user count
			}
		});
		btnNewButton_5.setBounds(200, 225, 175, 50);//sets bounds of button
		controlPanel.add(btnNewButton_5);//adds button to gui
		
		JButton btnNewButton_6 = new JButton("Show Group Total");//button to show group total
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Group count is " + groups.getChildCount());//calls method to get number of children and returns group number
			}
		});
		btnNewButton_6.setBounds(390, 225, 175, 50);//sets bounds of the button
		controlPanel.add(btnNewButton_6);//adds button to gui
		
		JButton btnNewButton_7 = new JButton("Show Messages Total");//button to show total amount of messages
		btnNewButton_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				UserControlPanel userControlPanel = new UserControlPanel();//creates new user control object and executes it
				tweetCount = userControlPanel.getTweetCount();//sets the tweet count to the stored number of tweets from the user control panel
				System.out.println("Message count: " + tweetCount);//prints out the amount of tweets made, stored in the ui
			}
		});
		btnNewButton_7.setBounds(200, 285, 180, 50);
		controlPanel.add(btnNewButton_7);//adds button to gui
		
		JButton btnNewButton_8 = new JButton("Show Positive Percentage");
		btnNewButton_8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("100 % positive messages");//all messages are positive
			}
		});
		btnNewButton_8.setBounds(390, 285, 190, 50);//sets bounds for positive percentage button
		controlPanel.add(btnNewButton_8);//adds button to gui
		
		userText.addContainerListener(new ContainerAdapter()
		{//overide for void method component added
			@Override
			public void componentAdded(ContainerEvent arg0){}
		});
		
	}
	}
