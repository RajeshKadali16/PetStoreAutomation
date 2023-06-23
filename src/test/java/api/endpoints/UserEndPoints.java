package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints {

	
	
	
	public static Response CreateUser(User payload)
	{
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when()
		   .post(Routes.postUrl);
	return response;
		
	}
	
	
	public static Response ReadUser(String userName)
	{
		Response response=given()
		   .pathParam("username", userName)
		.when()
		   .get(Routes.getUrl);
	return response;
		
	}
	public static Response UpdateUser(String User,User payload)
	{
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username",User)
		   .body(payload)
		.when()
		   .put(Routes.putUrl);
	return response;
		
	}
	public static Response deleteUser(String userName)
	{
		Response response=given()
		   .pathParam("username", userName)
		.when()
		   .delete(Routes.deleteUrl);
	return response;
		
	}
	
}
