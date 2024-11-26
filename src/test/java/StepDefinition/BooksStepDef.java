package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;

import java.io.IOException;

public class BooksStepDef {
    RequestSpecification baseRequest;
    RequestSpecification getRequest;
    RequestSpecification postRequest;
    RequestSpecification patchRequest;
    RequestSpecification deleteRequest;
    Response getResponse;
    Response postResponse;
    Response patchResponse;
    Response deleteResponse;

    @Before
    public void initiate() throws IOException {

        baseRequest = RestAssured.given()
                .baseUri("http://192.168.5.80:3000/api")
                .contentType(ContentType.JSON);

    }

    @Given("Enter the post url")
    public void enter_the_post_url() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("enter the book details")
    public void enter_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        postRequest = baseRequest.request();
    }

    @When("post the book details")
    public void post_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        JSONObject object = new JSONObject();
        object.put("name","Harry Potter: The Chamber of Secrets");
        object.put("authorName","J.K.Roewling");
        object.put("publishedYear","1995");
        object.put("price",680);

        postRequest.body(object.toJSONString());

        postResponse = postRequest.when()
                .post("/v1/book/addBook");

        System.out.println("POST Request : "+postResponse.asPrettyString());
    }

    @Then("validate the status code")
    public void validate_the_status_code() {
        // Write code here that turns the phrase above into concrete actions

    }


    @Then("validate the book name")
    public void validate_the_book_name() {
        // Write code here that turns the phrase above into concrete actions
        postResponse.then().log().ifStatusCodeIsEqualTo(200);

    }

    @Then("validate the price")
    public void validate_the_price() {
        // Write code here that turns the phrase above into concrete actions
        postResponse.then().body("price", CoreMatchers.is(680)).log();

    }

    @Then("Validate the Author")
    public void validate_the_author() {
        // Write code here that turns the phrase above into concrete actions
        postResponse.then().body("authorName",CoreMatchers.is("J.K.Roewling"));

    }

    @Given("Enter the url")
    public void enter_the_url() {
        // Write code here that turns the phrase above into concrete actions
        getRequest = baseRequest.request();

    }

    @When("get the book details")
    public void get_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        getResponse = getRequest.when().get("/v1/book/getAllBook");

        System.out.println("GET Response : "+getResponse.asPrettyString());
        getResponse.then().statusCode(200).log();

    }

    @Given("enter updated book details")
    public void enter_updated_book_details() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Book details updated");
    }

    @When("put the book details")
    public void put_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Put the book details");
    }

    @When("patch the book details")
    public void patch_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Patch the book details");
    }
}
