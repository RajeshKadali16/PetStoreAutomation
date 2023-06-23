package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

/*
 
 int id;
	     String username;
		  String firstName;
		  String lastName;
		  String email;
		 String password;
		String phone;
		int userStatus=0;
		*/
public class Testcases {
	Faker faker;
	User userpayload;

	@BeforeClass
	public void setupdata()
	{
		faker=new Faker();
		
		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().firstName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void PostRequest()
	{
		   Response response= UserEndPoints.CreateUser(userpayload);
		   response.then().log().all();
		   Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void GetRequest()
	{
		   Response response= UserEndPoints.ReadUser(this.userpayload.getUsername());
		   response.then().log().all();
		   Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void UpdateRequest()
	
	{
		
		//update user
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().firstName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		//updating the data
		
		   Response response= UserEndPoints.ReadUser(this.userpayload.getUsername());
		   response.then().log().all();
		   Assert.assertEquals(response.getStatusCode(), 200);
		   
		   //retrieving the data
		   Response responseAfterUpdation= UserEndPoints.ReadUser(this.userpayload.getUsername());
		   responseAfterUpdation.then().log().all();
		   Assert.assertEquals(responseAfterUpdation.getStatusCode(), 200);
		   
	}
	@Test(priority=4)
	public void DeleteRequest()
	{
		   Response response= UserEndPoints.deleteUser(this.userpayload.getUsername());
		   response.then().log().all();
		   Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
