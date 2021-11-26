import org.testng.Assert;
import org.testng.annotations.Test;

import API_Files.DATA;
import io.restassured.path.json.JsonPath;

public class TestCasesOn_Fake_API {

	JsonPath JS = new JsonPath(DATA.Fake_API());
	
	@Test(priority=1)
	public void TaskNum_One()
	{
		//Print No of courses returned by API
		
		 
		
		int Count = JS.getInt("courses.size");
		System.out.println(Count);
	}
	
	@Test(priority=2)
	public void TaskNum_Two()
	{
		// Print Purchase Amount
		
		 int purchaseAmount = JS.get("dashboard.purchaseAmount");
		 
		 System.out.println(purchaseAmount);
	}
	
	@Test(priority=3)
	public void TaskNum_Three()
	{
		// Print Title of the first course
		
		String Title = JS.get("courses[0].title");
		System.out.println(Title);
		
		
	}
	
	
	@Test(priority=4)
	public void TaskNum_Four()
	{
		// Print All course titles and their respective Prices
		
		int count = JS.getInt("courses.size");
		
		for (int i=0; i<count; i++)
		{
			String Titles = JS.get("courses["+i+"].title");
			int Prices = JS.get("courses["+i+"].price");
			
			System.out.println(Titles);
			System.out.println(Prices);
		}
	}
	
	
	@Test(priority=5)
	public void TaskNum_Five()
	{
		// Print no of copies sold by RPA Course
		
		String CourseName = JS.get("courses[2].title");
		int count = JS.getInt("courses.size");
		
		for (int i=0; i< count; i++)
		{
			if (CourseName.equalsIgnoreCase("RPA"))
			{
				int NumberOfCopies = JS.get("courses[2].copies"); 
				System.out.println("The Number of Copies is "+ NumberOfCopies);
				break; 
			}
		}
	}
	
	@Test(priority=6)
	public void TaskNum_Six()
	{
		// Verify if Sum of all Course prices matches with Purchase Amount
		
		int Sum = 0;
		int count = JS.getInt("courses.size");
		
		for (int i=0; i<count; i++)
		{
			int Price = JS.get("courses["+i+"].price");
			int copy = JS.get("courses["+i+"].copies");
			int Amount = Price*copy;
			
			Sum = Sum + Amount;
		}
		
		int Purchase = JS.get("dashboard.purchaseAmount");
		
		Assert.assertEquals(Sum, Purchase);
	}
	
	
	
}
