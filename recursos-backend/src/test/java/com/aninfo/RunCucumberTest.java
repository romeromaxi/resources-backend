package com.aninfo;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import com.aninfo.recursos.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},
                 features = {"src/test/resources/features"},
                 extraGlue = {"src/test/java/com/aninfo/steps"})
public class RunCucumberTest {

}