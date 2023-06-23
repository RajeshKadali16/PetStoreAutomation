package api.endpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Routes {
 
	public static String baseURL="https://petstore.swagger.io/v2";
	
	//user module
	
	public static String postUrl=baseURL+"/user";
	public static String getUrl=baseURL+"/user/{username}";
	public static String putUrl=baseURL+"/user/{username}";
	public static String deleteUrl=baseURL+"/user/{username}";
	
	//pet modeule
	
	//store module
	
	
	
}
