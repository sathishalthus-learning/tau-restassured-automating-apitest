package rest.zippopotam;

import org.junit.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class L2_BasicFeatures {
	
	// http://api.zippopotam.us/us
	
//	@Test
//	public void verifyStatuscode() {
//		given()
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//			.assertThat()
//			.statusCode(200)
//		;	
//	}
//	
//	@Test
//	public void verifyContentType() {
//		given()
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//			.assertThat()
//			.contentType(ContentType.JSON)
//			.contentType("application/json")
//		;	
//	}
	
//	@Test
//	public void logAll() {
//		given()
//			.log().all()
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//			.log().body()
//		;	
//	}
	
//	@Test
//	public void request90210_expectBeverlyHills() {
//		given()
//			//
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//			.assertThat()
//			.body("places[0].'place name'", equalTo("Beverly Hills"))
//		;	
//	}
	
//	@Test
//	public void request90210_verifySingleValue() {
//		given()
//			//
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//			.assertThat()
//			.body("places[0].'place name'", equalTo("Beverly Hills"))
//			.body("places.'place name'", equalTo("Beverly Hills"))
//		;	
//	}
	
	@Test
	public void request_verifyList() {
		given()
			//
		.when()
			.get("https://zippopotam.us/us/90210")
		.then()
		.log().body()
			.assertThat()
			.body("places.'place name'", hasItem("Beverly Hills"))
		;	
	}
}
