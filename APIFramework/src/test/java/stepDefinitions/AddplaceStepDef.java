package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testData.EnumClass;
import testData.TestDataMethods;
import testData.Utils;

public class AddplaceStepDef extends Utils{
	ResponseSpecification resspec;
	RequestSpecification req;
	Response r;
	TestDataMethods td=new TestDataMethods();
	static String placeID;

	@Given("Add place playload with {string} , {string} and {string}")
	public void add_place_playload_with_and(String name, String lang, String addr) throws IOException{

		req=given().spec(requestSpecification()).body(td.addPlacePayload(name,lang,addr)); //call method that returns obj of addplace serialization
	}

	@When("user tries to hit {string} with {string} request")
	public void user_tries_to_hit_with_request(String resource, String method) {
		//resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		EnumClass en=EnumClass.valueOf(resource);				//access the constructor of enum
		if(method.equalsIgnoreCase("POST"))
		{
		r=req.when().post(en.getResource())       //access the getters of enum
				.then().extract().response();
		}

		if(method.equalsIgnoreCase("GET"))
		{
			r=req.when().get(en.getResource())       //access the getters of enum
					.then().extract().response();
		}
	}

	@Then("the statuscode is {int}")
	public void the_statuscode_is(int code) {
	   assertEquals(r.getStatusCode(),code);
	   System.out.println("method is success");
	  
	}

	@Then("{string} in the response is {string}")
	public void in_the_response_is(String key, String value) {
	    assertEquals(getJsonvalue(r, key),value);

	}
	@Then("get the {string}")
	public void get_the(String place_id) {
		 placeID=getJsonvalue(r,"place_id");
	}
//	@Then("check if created place_id maps to {string} using {string}")
//	public void check_if_created_place_id_maps_to_using(String expname, String resource) throws IOException {
//	    String placeID=getJsonvalue(r,"place_id");
//		req=given().spec(requestSpecification()).queryParam("place_id", placeID);
//
//		//reuse the step2 to hit the endpoint using get method
//		user_tries_to_hit_with_request(resource, "GET");
//		String actualName=getJsonvalue(r,"name");
//		assertEquals(actualName,expname);
	//}
	@Given("Delete place playload")
	public void delete_place_playload() throws IOException {
	    req=given().spec(requestSpecification()).body(td.deleteReqPayload(placeID));

	}

}
