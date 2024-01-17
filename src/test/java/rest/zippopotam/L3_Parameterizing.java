package rest.zippopotam;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

//import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class L3_Parameterizing {
	
	// http://api.zippopotam.us/us
	
	@DataProvider
	public static Object[][]zipcodesAndPlaces(){
		return new Object[][] {
			{"us","90210","Beverly Hills"},
			{"us","12345", "Schenectady"},
			{"ca","B2R","Waverley"}
		};
	}

	@Test
	@UseDataProvider("zipcodesAndPlaces")
	public void pathParameters(String countryCode,String zipCode,String expectedPlace) {
		given()
			//path param
			.pathParam("countryCode", countryCode)
			.pathParam("zipCode", zipCode)
		.when()
			.get("https://zippopotam.us/{countryCode}/{zipCode}")
		.then()
		.log().body()
			.assertThat()
			.body("places[0].'place name'", equalTo(expectedPlace))
		;	
	}
//	@Test
//	public void queryParameters() {
//		given()
//			//
//		.when()
//			.get("https://zippopotam.us/us/90210")
//		.then()
//		.log().body()
//			.assertThat()
//			.body("places.'place name'", hasItem("Beverly Hills"))
//		;	
//	}
}
