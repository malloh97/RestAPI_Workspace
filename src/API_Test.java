import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class API_Test {

	public static void main(String[] args) 
	{
		
		RestAssured.baseURI="http://localhost:3000";
		
		/*
		 * Post New Customer
		 * 
		 */
		
		given().headers("Content-Type","application/json").body("{\r\n" + 
				"    \"name\": \"Ali\",\r\n" + 
				"    \"age\": \"26\",\r\n" + 
				"    \"Job\": \"Automation Test Engineer\",\r\n" + 
				"    \"Experience\": \"Three year\",\r\n" + 
				"    \"Location\": \"Jordan\"\r\n" + 
				"  }").when().post("/Customer")
		
		.then().log().all().assertThat().statusCode(201);

		/*
		 * Update Exist Customer
		 * 
		 */
		

		given().param("name", "Ali").headers("Content-Type","application/json").body("{\r\n" + 
				"    \"name\": \"Ali\",\r\n" + 
				"    \"age\": \"34\",\r\n" + 
				"    \"Job\": \"Automation Test Engineer\",\r\n" + 
				"    \"Experience\": \"six years\",\r\n" + 
				"    \"Location\": \"Jordan\"\r\n" + 
				"  }")
		
		.when().put("/Customer")
		
		.then().log().all().assertThat().statusCode(200);
		
		
		/*
		 * Get the Customer
		 * 
		 */
		
		given().param("name", "Ali").headers("Content-Type","application/json")
		
		.when().get("/Customer")
		
		.then().log().all().assertThat().statusCode(200); 
		
		
	}

}
