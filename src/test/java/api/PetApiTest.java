package api;

import api.pojo.Pet;
import com.github.javafaker.File;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class PetApiTest {

    @Test
    public void deletePetTest() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "pet/9223372016900017000")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void addNewPetTest() {
        Pet kot = new Pet();
        given()
                .when().contentType(ContentType.JSON)
                .body(kot)
                .post(Environment.uri + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void updatePetTest() {
        Pet kot = new Pet();
        given()
                .when().contentType(ContentType.JSON)
                .body(kot)
                .put(Environment.uri + "pet")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void findPetByStatus() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "pet/findByStatus?status=sold")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void findPetById() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "pet/9223372016900017000")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void updatePetWithFormDataTest() {
        given()
                .when().contentType(ContentType.URLENC)
                .formParam("name", "kot", "status", "sold")
                .post(Environment.uri + "pet/9223372016900017000")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void uploadImage() {
        String filePath = "/Загрузки/Без названия.jpg";
        String uploadEndpoint = Environment.uri;
        File fileToUpload = new File(filePath);
        given()
                .multiPart(fileToUpload)
                .when().contentType(ContentType.MULTIPART)
                .post(uploadEndpoint + "pet/9223372036854762424/uploadImage")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
