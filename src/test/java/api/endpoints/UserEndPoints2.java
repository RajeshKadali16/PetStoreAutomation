package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints2 {

	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response CreateUser(User payload)
	
	{
		
		String post_url=getURL().getString("postUrl");
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		   .post(post_url);
	return response;
		
	}
	
	
	public static Response ReadUser(String userName)
	
	{
		String get_url=getURL().getString("getUrl");
		Response response=given()
		   .pathParam("username", userName)
		.when()
		   .get(get_url);
	return response;
		
	}
	public static Response UpdateUser(String User,User payload)
	
	{
		String update_url=getURL().getString("putUrl");
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",User)
		   .body(payload)
		.when()
		   .put(update_url);
	return response;
		
	}
	public static Response deleteUser(String userName)
	
	{
		

		String delte_URL=getURL().getString("deleteUrl");
		
		Response response=given()
		   .pathParam("username", userName)
		.when()
		   .delete(delte_URL);
	return response;
		
	}
	
}
