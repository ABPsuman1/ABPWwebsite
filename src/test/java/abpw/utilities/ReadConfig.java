package abpw.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig	
	{
		Properties Pro;
		public ReadConfig() 
			{
				File src = new File("./Configuration/config.properties");
				try {
						FileInputStream fis =new FileInputStream(src);
						Pro =new Properties();
						Pro.load(fis);
					} 
				catch (Exception e) 
					{
						System.out.println("Exception is " + e.getMessage());
					}
			}
		
		public String getURL() 
		{
			String url=Pro.getProperty("websiteURL");
			return url;
		}
		public String getDBurl()
		{
			String DBurl=Pro.getProperty("dburl");
			return DBurl;
		}
		public String getDBusername()
		{
			String DBusername=Pro.getProperty("dbusername");
			return DBusername;
		}
		public String getDBpassword()
		{
			String DBpassword=Pro.getProperty("dbpassword");
			return DBpassword;
		}
	
//		========================= CRM Related ====================================
		public String getCRMurl()
		{
			String crmUrl=Pro.getProperty("newCRMurl");
			return crmUrl;
		}
		public String getModerationTLuser()
		{
			String user_moderationTL=Pro.getProperty("userModerationTL");
			return user_moderationTL;
		}
		public String getModerationTLuserPassword()
		{
			String user_moderationTL_password=Pro.getProperty("userModerationTL_password");
			return user_moderationTL_password;
		}
		public String getModerationEXEname()
		{
			String user_ModerationEXEname=Pro.getProperty("userModerationEXE_Name");
			return user_ModerationEXEname;
		}
		public String getModerationEXEuser()
		{
			String user_ModerationEXE_user=Pro.getProperty("userModerationEXE");
			return user_ModerationEXE_user;
		}
		public String getModerationEXEpassword()
		{
			String user_ModerationEXE_password=Pro.getProperty("userModerationEXE_password");
			return user_ModerationEXE_password;
		}
		
	}
