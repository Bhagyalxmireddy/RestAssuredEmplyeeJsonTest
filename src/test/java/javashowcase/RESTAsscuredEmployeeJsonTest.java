package javashowcase;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;

public class RESTAsscuredEmployeeJsonTest {

    final static String EMPLOYEE_LIST = " http://localhost:3000/employees";

    @Test
    public void onCallingList_ReturnEmployeeList() {
        Response response = get(EMPLOYEE_LIST + "/list");
        System.out.println("AT FIRST: " + response.asString());
        response.then().body("id", Matchers.hasItems(1,2));
        response.then().body("name", Matchers.hasItems("pankaj"));
    }


}
