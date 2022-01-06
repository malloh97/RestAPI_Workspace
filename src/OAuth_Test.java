import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import API_Files.DATA;
import POJO_Classes.Api;
import POJO_Classes.GetCourses;
import POJO_Classes.webAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;

public class OAuth_Test {
	
	public static String Code; 
	
	@Test(priority=1, enabled = false)
	public void GetTheCode()
	{
		WebDriver driver; 
			
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(DATA.Account_URL());
		
		driver.findElement(By.id("identifierId")).sendKeys("ahmXXXXXXXX@gmail.com");
		driver.findElement(By.xpath("//button[contains(@jsname,'LgbsSe')]")).click();
		
		driver.findElement(By.name("password")).sendKeys("XXXX");
		driver.findElement(By.xpath("//button[contains(@jsname,'LgbsSe')]")).click();
		
		Code = driver.getCurrentUrl();
	}
	
	@Test(priority=2)
	public void Get_Token()
	{
		//RestAssured.baseURI = "https://www.googleapis.com/oauth2/v4/token"; 
		
		String accessTokenResponse=	given().urlEncodingEnabled(false)
			.queryParams("code",DATA.Get_Code())
			.queryParams("client_id",DATA.Get_client_id())
			.queryParams("client_secret",DATA.Get_client_secret())
			.queryParams("redirect_uri",DATA.Get_redirect_uri())
			.queryParams("grant_type","authorization_code")
			.when()
			.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
			JsonPath js=new JsonPath(accessTokenResponse);
			String accessToken=js.getString("access_token");
		
	
			System.out.println(accessToken);
		
	     	GetCourses GC = given().queryParam("access_token", accessToken)
		   .expect().defaultParser(Parser.JSON)
		   .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		
		
		// print the price of SoapUI Webservices testing Course
		List<Api> apiCourses=GC.getCourses().getApi();
		for(int i=0;i<apiCourses.size();i++)
		{
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
				System.out.println(apiCourses.get(i).getPrice());
					}
		}
		
		
		// print the Courses in the webAutomation
		List<webAutomation> webCourses = GC.getCourses().getWebAutomation();
		
		for (int i=0; i< webCourses.size(); i++)
		{
			System.out.println(webCourses.get(i).getCourseTitle());
		}
		
	
	}
}
