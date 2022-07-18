package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class testApi {
	
	public String url = "https://reqres.in/api/users?page=2";
	
	@Test
	public void ValidarStatusCode() {
		
		given()
		.when()
			.get(url)
		.then()
			.statusCode(200);
		
	}

	@Test
	public void ValidarDados() {
		
		given()
		.when()
			.get(url)
		.then()
			.body("data[5].id", is(12))
			.body("data[5].email",is("rachel.howell@reqres.in"))
			.body("data[5].first_name",is("Rachel"))
			.body("data[5].last_name", is("Howell"))
			.body("data[5].avatar", is("https://reqres.in/img/faces/12-image.jpg"));
		
	}
}
