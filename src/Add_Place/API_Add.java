package Add_Place;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class API_Add {
	
	POJO_Body body = new POJO_Body();
	Get_Responce Res = new Get_Responce();
	
	@Test
	public void Add_Place()
	{
		body.setAccuracy(50);
		body.setName("Frontline house");
		body.setPhone_number("(+91) 0 893 3937");
		body.setAddress("29, side layout, cohen 09");
		body.setWebsite("http://google.com");
		body.setLanguage("French-IN");
		
		List <String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		body.setTypes(types);
		
		get_Location loc = new get_Location();
		loc.setLat(-38.383494);
		loc.setLng(38.383494);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Get_Responce Response = given().queryParam("key", "qaclick123").header("Content-Type","application/json").urlEncodingEnabled(false)
		.body(body).expect().defaultParser(Parser.JSON)
		.when().post("/maps/api/place/add/json").as(Get_Responce.class);
		
		System.out.println(Response.getPlace_id());
	}
	

}
