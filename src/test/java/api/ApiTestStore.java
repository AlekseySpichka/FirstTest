package api;

import api.pojo.Order;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTestStore {

    @Test
    public void createOrder() {
        Order order = new Order();
        given()
                .when().contentType(ContentType.JSON)
                .body(order)
                .post(Environment.uri + "store/order")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void findPurchaseByOrderId() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "store/order/9")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void deletePurchaseByOrderId() {
        given()
                .when().contentType(ContentType.JSON)
                .delete(Environment.uri + "store/order/8")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void returnInventoryByStatus() {
        given()
                .when().contentType(ContentType.JSON)
                .get(Environment.uri + "store/inventory")
                .then().log().all()
                .assertThat().statusCode(200);
    }

}
