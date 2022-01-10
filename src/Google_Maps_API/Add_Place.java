package Google_Maps_API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Add_Place {
	
	@Test
	public void add_Place()
	{
		
		Get_Request body = new Get_Request();
		Locations location = new Locations();
		
		body.setAccuracy(50);
		body.setAddress("29, side layout, cohen 09");
		body.setLanguage("French-IN");
		body.setWebsite("http://google.com");
		body.setName("Frontline house");
		
		List <String> types = new ArrayList <String>() ; 
		types.add("shoe park");
		types.add("shop");	
		
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		  RequestSpecification Request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").build();
		
		 ResponseSpecification Response = new ResponseSpecBuilder().expectStatusCode(200).build(); 
		  
		  
		  
		RequestSpecification Res =  given().spec(Request).body(body); 
		Response responce =  Res.when().post("/maps/api/place/add/json")
		.then().spec(Response).extract().response();
		
		
		String Get = responce.asString();
		System.out.println(Get);
	}
	
	

}
