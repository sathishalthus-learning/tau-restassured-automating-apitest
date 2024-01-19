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
public class L5_XmlResponses {
	
	// http://api.zippopotam.us/us
	
	
	@Test
	public void requestResponseAndExtract() {
		given()
		.when()
			.get("http://localhost:9876/us/90210")
		.then()
			.assertThat()
			.body("response.places.place.placename", equalTo("Beverly Hills"))
//			.body("response.places.place[2].placename", equalTo("Beverly Hills"))
//			.body("response.places.place[2].@attribute", equalTo("Beverly Hills"))
		;
			}
	
}
