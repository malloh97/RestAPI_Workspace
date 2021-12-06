package API_Files;

public class DATA {
	
	public static String Add_New_Employee()
	{
		return "{\r\n" + 
				"    \"name\": \"Ammar\",\r\n" + 
				"    \"age\": \"27\",\r\n" + 
				"    \"Job\": \"Front End Developer\",\r\n" + 
				"    \"Experience\": \"Ten years\",\r\n" + 
				"    \"Location\": \"Jordan\"\r\n" + 
				"  }" ; 
	}
	
	
	public static String Fake_API()
	{
		return "{\r\n" + 
				"  \r\n" + 
				"  \"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				""; 
	}
	
	public static String NewCustomer(String Name, String Age)
	{
		return "{\r\n" + 
				"    \"name\": \""+Name+"\",\r\n" + 
				"    \"age\": \""+Age+"\",\r\n" + 
				"    \"Job\": \"Automation Test Engineer\",\r\n" + 
				"    \"Experience\": \"Two year\",\r\n" + 
				"    \"Location\": \"Jordan\"\r\n" + 
				"  }" ; 
	}
	
	
	public static String UpdateAddedCustomer(String Name, String Age)
	{
		return "{\r\n" + 
				"    \"name\": \""+Name+"\",\r\n" + 
				"    \"age\": \""+Age+"\",\r\n" + 
				"    \"Job\": \"Automation Test Engineer\",\r\n" + 
				"    \"Experience\": \"Two year\",\r\n" + 
				"    \"Location\": \"Jordan\"\r\n" + 
				"  }" ; 
	}
	
	
	
	
	
	public static String Update_User()
	{
		return "{\r\n" + 
				"    \"id\": 1,\r\n" + 
				"    \"name\": \"Ahmad Malloh\",\r\n" + 
				"    \"username\": \"malloh\",\r\n" + 
				"    \"email\": \"malloh@yopmail.com\",\r\n" + 
				"    \"address\": {\r\n" + 
				"      \"street\": \"Amman\",\r\n" + 
				"      \"suite\": \"Khalda\",\r\n" + 
				"      \"city\": \"Amman\",\r\n" + 
				"      \"zipcode\": \"90001\",\r\n" + 
				"      \"geo\": {\r\n" + 
				"        \"lat\": \"-37.3159\",\r\n" + 
				"        \"lng\": \"81.1496\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"phone\": \"12345681220\",\r\n" + 
				"    \"website\": \"APITest.org\",\r\n" + 
				"    \"company\": {\r\n" + 
				"      \"name\": \"API Company\",\r\n" + 
				"      \"catchPhrase\": \"Multi-layered client-server neural-net\",\r\n" + 
				"      \"bs\": \"harness real-time e-markets\"\r\n" + 
				"    }\r\n" + 
				"  }" ; 
	}

	
	
	
	
	public static String CreateUser_API()
	{
		return "{\r\n" + 
				"    \"name\": \"Khaled\",\r\n" + 
				"    \"job\": \"Automation Software Engineer\"\r\n" + 
				"}" ; 
	}
	
	
	
	
	
}
