package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Get_AllBooks {
    @Test
    public void getallbook()
    {
        Response res= RestAssured.get("http://192.168.5.80:3000/api/v1/book/getAllBook");
        System.out.println("Status code: "+res.getStatusCode());
        System.out.println("Status: "+res.getSessionId());
        System.out.println("Response Body:"+res.getBody().prettyPrint());

//        Response ser=RestAssured.post("http://192.168.5.80:3000/api/v1/book/addBook");
//        ser.
    }
}
