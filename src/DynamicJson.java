
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
	
	@BeforeMethod
    public void beforeMethod()
    {
		RestAssured.baseURI = "http://localhost:3000";
    }
	
	
	@Test(priority = 1, dataProvider = "JsonData")
	public void AddNewCustomer(String Name , String Age)
	{
		
		// Add New Customer
		
		given().log().all().header("Content-Type","application/json").body(API_Files.DATA.NewCustomer(Name , Age)).
		when().post("/Customer").
		then().assertThat().statusCode(201).body("name",equalTo(Name));
		
		
	}
	
	
	String Age; 
	@Test(priority = 2, dataProvider = "JsonData")
	public void UpdateAddedCustomer(String Name , String Age)
	{
		String Res = given().log().all().param("name", "Maan").header("Content-Type","application/json").body(API_Files.DATA.UpdateAddedCustomer(Name , Age)).
		when().put("/Customer").
		then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath JS = new JsonPath(Res); 
		Age = JS.getString("age"); 
		
		System.out.println(Age);
		
		
	}
	
	
	@Test(priority = 3, dataProvider = "JsonData")
	public void GetCustomer(String Name , String Age)
	{
		//String ExpectedAge = "46";
		
		String Res = given().log().all().param("name", Name).header("Content-Type","application/json").
		when().get("/Customer")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath JS = new JsonPath(Res); 
		Age = JS.getString("age"); 
		
		System.out.println(Age);
		
		//Assert.assertEquals(Age, ExpectedAge);
		
	}
	
	@DataProvider(name = "JsonData")
	public Object[][] SetData()
	{
		Object [][] Data = {{"Name1","10"} , {"Name2","11"} , {"Name3","12"}} ; 
		
		return Data; 
	}
	
	
	

}
