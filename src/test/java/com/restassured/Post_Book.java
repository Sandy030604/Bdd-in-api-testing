package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Post_Book {

    @Test
    public void postbooks() {
        JSONObject req = new JSONObject();
        RestAssured.baseURI = "http://192.168.5.80:3000/api";

        req.put("name", "How Make Money");
        req.put("authorName", "Ram");
        req.put("publishedYear", "01/11/1992");
        req.put("price", 1070);

        given().contentType(ContentType.JSON).body(req.toJSONString())
//                .when()
                .post("/v1/book/addBook");
                //then().log().all();

    }
}
