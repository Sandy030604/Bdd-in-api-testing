package com.restassured;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class Get_AllBooksBDD {


    @Test
    public void getallbooks()
    {
        RestAssured.baseURI ="http://192.168.5.80:3000/api";

        RestAssured.
                get("v1/book/getAllBook").
                then().statusCode(200).body("authorname[1]", CoreMatchers.equalTo("Santhosh"));


    }
}
