package com.aninfo;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import com.aninfo.recursos.*;

/* Cuando se agreguen scenarios en hours.feature, cambiar la option en CucumberOptions por:
features = { "src/test/resources/com/aninfo/resources", "src/test/resources/com/aninfo/hours" }
*/
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},
                 features = { "src/test/resources/com/aninfo/resources" } )
public class RunCucumberTest {

}