package rest.zippopotam;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import entities.Location;
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
public class L6_Serialization {
	
	// http://api.zippopotam.us/us
	
	@Test
    public void serialzation() {

        Location location =
        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        as(Location.class);
        
        assertEquals("Beverly Hills",location.getPlaces().get(0).getPlaceName())
        ;
			}
	
	@Test
    public void deSerialzation() {

        Location location = new Location();
        location.setCountry("Netherlands");

        given().
            contentType(ContentType.JSON).
            body(location).
            log().body().
        when().
            post("http://localhost:9876/lv/1050").
        then().
            assertThat().
            statusCode(200);
			}
}
