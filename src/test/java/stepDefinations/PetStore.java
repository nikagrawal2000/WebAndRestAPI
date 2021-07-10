package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.CommonUtils;
import utils.RestServices;

public class PetStore extends RestServices {
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response;
	Logger logger = CommonUtils.getRestAPILoggerInstance();

	@Given("^\"([^\"]*)\" request$")
	public void somethingRequest(String request) {
		if (request.equalsIgnoreCase("POST")) {
			reqspec = new RequestSpecBuilder().setBaseUri(config.getBaseUrl())
					.addHeader("Content-Type", "application/json").build();
		} else if (request.equalsIgnoreCase("PUT")) {
			reqspec = requestSpecification();
			reqspec.headers("Content-Type", "application/json");
		} else if (request.equalsIgnoreCase("GET")) {
			reqspec = requestSpecification();
		} else if (request.equalsIgnoreCase("DELETE")) {
			reqspec = requestSpecification();
		}

	}

	@When("^Customer \"([^\"]*)\" dog with name \"([^\"]*)\" with ID \"([^\"]*)\"$")
	public void customer_dog_with_name_and_id(String action, String dogName, int id) throws IOException {
		if (action.equalsIgnoreCase("adds")) {
			reqspec = given(reqspec).body(getPayload(id, dogName));
			response = reqspec.when().post("/pet");
		} else if (action.equalsIgnoreCase("updates")) {
			reqspec = given(reqspec).body(getPayload(id, dogName));
			response = reqspec.when().post("/pet");
		} else if (action.equalsIgnoreCase("deletes")) {
			response = given(reqspec).delete("/pet/" + id);
		} else if (action.equalsIgnoreCase("checks")) {
			response = given(reqspec).get("/pet/" + id);
		} else if (action.equalsIgnoreCase("verifies")) {
			JsonPath jsonPath = response.getBody().jsonPath();
			assertEquals(Integer.valueOf(id), jsonPath.get("id"));
			logger.info("Pet with id " + id + " matches successfully");
			assertEquals(dogName, jsonPath.get("name"));
			System.out.println("matching " + dogName + " " + jsonPath.get("name"));
		}

	}

	@Then("^I receive response code \"([^\"]*)\"$")
	public void i_recieve_response_code(int responseCode) {
		assertEquals(responseCode, response.getStatusCode());
		logger.info("Response code found " + responseCode + " successfully");

	}

}
