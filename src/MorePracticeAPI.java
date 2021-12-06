import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import API_Files.DATA;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class MorePracticeAPI {
	
	static String name;
	
	@BeforeTest
	public void beforeTest()
	{
		RestAssured.baseURI = "https://reqres.in";
		
	}
	
	
	@Test(priority=1)
	public void Get_AllData()
	{
		String Response = given().queryParam("page", "2").header("Content-Type","application/json")
		.when().get("/api/users")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("The API returned this data: " + Response);

	}
	
	
	static String User_Id;
	@Test(priority=2)
	public void Create_User()
	{
		String Result = given().header("Content-Type","application/json").body(DATA.CreateUser_API())
		.when().post("/api/users/"+User_Id)
		.then().assertThat().statusCode(201).body("name", equalTo("Khaled")).extract().response().asString();
		
		JsonPath JS = new JsonPath(Result);
		User_Id = JS.getString("id");
		
		System.out.println("The User Id is  " + User_Id);
	}
	
	
	@Test(priority=3)
	public void Get_AddedUser()
	{
		String Result = given().queryParam("id", User_Id).header("Content-Type","application/json")
		.when().get("/api/users")
		.then().assertThat().statusCode(200).body("id", equalTo(User_Id)).extract().response().asString();
		
		JsonPath JS = new JsonPath(Result);
		String Actual_Id = JS.getString("id");
		
		Assert.assertEquals(User_Id, Actual_Id);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
