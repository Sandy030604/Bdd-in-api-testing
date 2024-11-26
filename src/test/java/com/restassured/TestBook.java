package com.restassured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\santhosh.krishnan\\eclipse-workspace\\Rest_Assured\\src\\test\\java\\Features\\Books.feature"},
        glue = {"StepDefinition"},
        monochrome = true
)

public class TestBook {
}

