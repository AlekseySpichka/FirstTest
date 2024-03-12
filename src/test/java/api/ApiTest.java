package api;

import api.pojo.User;
import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.*;

public class ApiTest {

//    @Test
//    public void getUserTest() {
//        String userName = "Test";
//        User alex = given()
//                .when()
//                .get(Environment.uri + "user/" + userName)
//                .then().log().all()
//                .assertThat().statusCode(404)
//                .extract().as(User.class);
//        Assert.assertNull(alex);
//    }

    @Test
    public void createUserTest() {
        User john = new User();
        given()
                .when().contentType(ContentType.JSON)
                .body(john)
                .post(Environment.uri + "user")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void createUserWithArray() {
        User[] users = Environment.getArrayUsers(5);
        given()
                .when().contentType(ContentType.JSON)
                .body(users)
                .post(Environment.uri + "user/createWithArray")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void createUserWithList() {
        List<User> users = Environment.getListUsers(5);
        given()
                .when().contentType(ContentType.JSON)
                .body(users)
                .post(Environment.uri + "user/createWithList")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void updateUser() {
        User user = new User();
        given()
                .when().contentType(ContentType.JSON)
                .body(user)
                .put(Environment.uri + "user/2")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void deleteUser() {
        given()
                .when().contentType(ContentType.JSON)
                .delete(Environment.uri + "user/2")
                .then().log().all()
                .assertThat().statusCode(404);
    }

    @Test
    public void deleteUserPositive() {
        given()
                .when().contentType(ContentType.JSON)
                .delete(Environment.uri + "user/Test")
                .then().log().all()
                .assertThat().statusCode(404);
    }

    @Test
    public void loginUser() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "user/login?username=1&password=123")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void logoutUser() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "user/logout")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
