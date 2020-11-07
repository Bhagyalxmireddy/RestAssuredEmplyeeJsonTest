package javashowcase;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class RESTAsscuredEmployeeJsonTest {

    private int empId;

    @Before
    public  void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
        empId = 9;
    }

    public Response getEmployeeList(){
        Response response = RestAssured.get("/employees");
        return response;
    }

    @Test
    public void onCallingList_ReturnEmployeeList() {
        Response response = getEmployeeList();
        System.out.println("AT FIRST: " + response.asString());
        response.then().body("id", Matchers.hasItems(1,2));
        response.then().body("name", Matchers.hasItem("Pankaj"));
    }


}
