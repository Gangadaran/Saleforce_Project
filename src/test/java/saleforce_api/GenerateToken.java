package saleforce_api;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.GenerateTokenBear;
import pojo.GetId;


public class GenerateToken {
	public  String access_token;
	public String ID; 
	
	@Test
	public void testGenerate() {
		
		HashMap<String,String> map = new HashMap<>();
		map.put("grant_type", "password");
		map.put("client_id", "3MVG9pRzvMkjMb6lZlt3YjDQwe0hk0f5ZPyWD38tfPYQ75KXUzZBGzM_c7I0o3yc6ua1IUk6lEQIy4U2sByrg");
		map.put("client_secret", "79FFF874D54193B377A60354C71CBBE83120AD28A5D6BC536D2F68C94645DE98");
		map.put("username", "ranjini.r@testleaf.com");
		map.put("password", "Testleaf$321");
		
		RestAssured.baseURI = "https://testleaf30-dev-ed.develop.my.salesforce.com";
		        
		GenerateTokenBear generateToken = RestAssured
			    .given()
			    .contentType("application/x-www-form-urlencoded")
			    .formParams(map)
			    .post("/services/oauth2/token")
			    .then()
			    .extract()
			    .as(GenerateTokenBear.class);
		         
		         
		access_token =generateToken.getAccess_token();  
		
			
	}
	
	@Test(dependsOnMethods = "testGenerate")
	public void creatLead() {
		RestAssured.baseURI = "https://testleaf30-dev-ed.develop.my.salesforce.com/";
		 GetId id = RestAssured
		.given()
		.auth()
		.oauth2(access_token)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.body("{\r\n"
				+ "    \"FirstName\": \"Eagle\",\r\n"
				+ "    \"LastName\": \"R\",\r\n"
				+ "    \"Company\": \"agle\"\r\n"
				+ "}")
		.post("services/data/v58.0/sobjects/Lead/").then().extract().as(GetId.class);
		 
		 ID = id.getId();
		 
	}
	
	@Test(dependsOnMethods = "creatLead")
	public void getDetails() {
		RestAssured.baseURI = "https://testleaf30-dev-ed.develop.my.salesforce.com/";
		 Response response = RestAssured
		.given()
		.auth()
		.oauth2(access_token)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.get("/services/data/v58.0/sobjects/Lead/"+ID);
		 
		 response.prettyPrint();

	}

}
