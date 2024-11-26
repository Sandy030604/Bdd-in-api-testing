package com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Post_UsingExcel {
    FileInputStream input;
    XSSFWorkbook XPost;
    XSSFSheet XSHeet;
    @Test
    public void addBook() throws IOException {
        input=new FileInputStream("C:\\Users\\santhosh.krishnan\\eclipse-workspace\\Rest_Assured\\API Data new.xlsx");
        XPost=new XSSFWorkbook(input);
        XSHeet=XPost.getSheet("API");





//        int row=XSHeet.getPhysicalNumberOfRows();
//        System.out.println(row);
        for(Row row : XSHeet){
            if(row.getCell(0).getStringCellValue().equals("GET")){
                Response res= RestAssured.get(row.getCell(1).getStringCellValue());//extract will actually return the whole header,body,cookies to the variable

                System.out.println("Get Methoid returns: "+res.asPrettyString());
            }
            else if(row.getCell(0).getStringCellValue().equals("POST"))
            {
                JSONObject obj=new JSONObject();
                obj.put("name","Kanguva");
                obj.put("authorName","Cheetah");
                obj.put("publishedYear","2024");
                obj.put("price","100");
                Response res=RestAssured.given().contentType(ContentType.JSON).body(obj.toJSONString()).post(row.getCell(1).getStringCellValue());
                System.out.println("Post"+res.getBody().asPrettyString());

                System.out.println("POST COMPLETED ____________________________________________________________________________--");

            }
            else if(row.getCell(0).getStringCellValue().equals("PATCH"))
            {
                JSONObject obj=new JSONObject();
                obj.put("publishedYear",String.valueOf(row.getCell(4).getNumericCellValue()));
                Response res=RestAssured.given().contentType(ContentType.JSON).body(obj.toJSONString()).patch(row.getCell(1).getStringCellValue()).andReturn();
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("PATCH"+res.getBody().asPrettyString());
                System.out.println("PATCH METHOD");

            }
            else if(row.getCell(0).getStringCellValue().equals("DELETE"))
            {
                Response res=RestAssured.given().delete(row.getCell(1).getStringCellValue());
                System.out.println("DELETE____________________________________________________");
                System.out.println("DELETE METHOD");
            }
        }



    }
}
