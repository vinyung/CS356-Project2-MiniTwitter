package miniTwitter;//imports package mini twitter

import miniTwitter.AdminControlPanel;//imports admin control panel class

public class TestDriver 
{
//class test driver is used to initialize the control panel
	public static void main(String[] args) 
	{
		AdminControlPanel adminPanel = new AdminControlPanel();//creates new control panel object
		adminPanel.run();//executes method run which displays the admin control panel
	}
}
