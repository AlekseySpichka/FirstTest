package api;

import api.pojo.Pet;
import io.restassured.http.ContentType;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetApiTest {

    @Test
    public void deletePetTest() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "pet/" + getPetId())
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
                .get(Environment.uri + "pet/" + getPetId())
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void updatePetWithFormDataTest() {
        given()
                .when().contentType(ContentType.URLENC)
                .formParam("name", "kot")
                .formParam("status", "sold")
                .post(Environment.uri + "pet/" + getPetId())
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void uploadImage() {
        String filePath = "src/main/resouces/kartinka.jpg";
        given()
                .multiPart(new File(filePath))
                .formParam("additionalMetadata", "12345")
                .when().contentType("multipart/form-data")
                .post(Environment.uri + "pet/9223372036854762424/uploadImage")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    public Long getPetId() {
        ArrayList<LinkedHashMap> list = given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "pet/findByStatus?status=available")
                .then().assertThat().statusCode(200)
                .extract().as(ArrayList.class);
        return (Long) list.get(0).get("id");
    }
}
