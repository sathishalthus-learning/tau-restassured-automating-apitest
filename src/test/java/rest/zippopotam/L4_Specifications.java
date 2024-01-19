package rest.zippopotam;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

//import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class L4_Specifications {
	
	// http://api.zippopotam.us/us
	private static RequestSpecification requestSpecification;
	private static ResponseSpecification responseSpecification;
	
	@BeforeClass
	public static void createRequestSpecification() {
		requestSpecification = new RequestSpecBuilder()
				.setBaseUri("http://api.zippopotam.us")
				.build();
	}
	
	@BeforeClass
	public static void createResponseSpecification() {
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	@Test
	public void requestResponseAndExtract() {
		
		String placeName =
		given()
			.spec(requestSpecification)
		.when()
			.get("/us/90210")
		.then()
			.spec(responseSpecification)
			.log().body()
			.assertThat()
			.body("places.'place name'", hasItem("Beverly Hills"))
			.extract().path("places[0].'place name'")
		;	
		Assert.assertEquals(placeName, "Beverly Hills");
	}
	
}
