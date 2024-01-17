package rest.zippopotam;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class L1_Introduction {
	
	// http://api.zippopotam.us
	// RESTful API
	
//	@Test
//	public void getAllZipCodes() {
//		given()
//		.when()
//			.get("https://zippopotam.us")
//		.then()
//			.statusCode(200)
//			.log().body()
//		;	
//	}
	
	@Test
	public void requestZipcode90210_ExpextBeverlyHills() {
		given()
		.when()
			.get("https://zippopotam.us/us/90210")
		.then()
			.assertThat()
			.body("places[0].'place name'", equalTo("Beverly Hills"))
		;	
	}
}
