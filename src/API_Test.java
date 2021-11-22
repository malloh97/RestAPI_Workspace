import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import API_Files.DATA;

public class API_Test {

	public static void main(String[] args) 
	{
		
		
		RestAssured.baseURI="http://localhost:3000";
		
	    /*
	     * Add New Employee
	     * 
	     */
		 
		String Responce = given().log().all().headers("Content-Type" , "application/json").body(DATA.Add_New_Employee())
		
		
		.when().post("/Customer")
		
		.then().assertThat().statusCode(201).body("name", equalTo("Ammar")).extract().response().asString();  
	
	    
	    JsonPath JS = new JsonPath(Responce); 
	    String Emp_Name = JS.getString("name"); 
	
	    System.out.println("New Empolyee Added");
	    System.out.println(Responce);
	
	    /*
	     * Update Employee
	     * 
	     */
	
	
	    String Put_Responce = given().log().all().queryParam("name", "Ammar").headers("Content-Type" , "application/json").body("{\r\n" + 
	    		"    \"name\": \""+Emp_Name+"\",\r\n" + 
	    		"    \"age\": \"22\",\r\n" + 
	    		"    \"Job\": \"Automation Test Engineer\",\r\n" + 
	    		"    \"Experience\": \"Five years\",\r\n" + 
	    		"    \"Location\": \"Jordan\"\r\n" + 
	    		"}")
	    
	    .when().put("/Customer")
	    
	    .then().assertThat().statusCode(200).body("Experience", equalTo("Five years")).extract().response().asString();
	
	    JsonPath JS1 = new JsonPath(Put_Responce);
	    String Updated_Expereice = JS1.getString("Experience"); 
	    
	
	    System.out.println("New Empolyee Updated");
	    System.out.println(Put_Responce);
	
	    /*
	     * Get The Data Of Updated Employee
	     * 
	     */
	
	
	     String Get_Responce = given().queryParam("name", "Ammar").headers("Content-Type" , "application/json")
	     
	     .when().get("/Customer")
	     
	     .then().assertThat().statusCode(200).body("name", equalTo("Ammar")).extract().response().asString();
	
	     JsonPath JS2 = new JsonPath(Get_Responce);
		 String Actual_Expereice = JS2.getString("Experience"); 
		    
		 System.out.println("New Empolyee Returned");
		 System.out.println(Get_Responce);
		 Assert.assertEquals(Updated_Expereice, Actual_Expereice);
	
	
	}

}
