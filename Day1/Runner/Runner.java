package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/TestLeafTaps.feature", glue="steps", monochrome=true, publish=true)
public class Runner extends AbstractTestNGCucumberTests {

}
