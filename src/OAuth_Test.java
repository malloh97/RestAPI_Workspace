import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import API_Files.DATA;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuth_Test {
	
	public static String Code, Token; 
	
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
	
	@Test(priority=2, enabled = false)
	public void Get_Token()
	{
		RestAssured.baseURI = "https://www.googleapis.com/oauth2/v4/token"; 
		
		String Response = given()
		.queryParam("code", DATA.Get_Code())
		.queryParam("client_id", DATA.Get_client_id())
		.queryParam("client_secret", DATA.Get_client_secret())
		.queryParam("redirect_uri", DATA.Get_redirect_uri())
		.queryParam("grant_type", "authorization_code")
		.when().post()	
		.then().extract().response().asString();
		
		JsonPath JS = new JsonPath(Response);
		Token = JS.getString("access_token");
		
	}
	
	@Test(priority=3)
	public void Get_Courses()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/getCourse.php"; 
		
		String Response = given().queryParam("access_token", "ya29.a0ARrdaM8f8EwRPL7JPj9egDJiQtGZqp_q6aIO9lWIQWAVXcS4MKsrowVZ41AWXXFIjuo46aGIPkJm1tOJBrNWGruEqYB6PNJUl3pyyeiCzhvSLqRRaXwdBdoLAVFElG9lozLqdaXF6AJqRAVmuUs_e-8u1-d2aA")
		.when().get()
		.then().statusCode(200).extract().response().asString();
		
		System.out.println(Response);
		
	}
	

}
