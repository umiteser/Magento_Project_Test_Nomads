package Runners;

import Utilities.GWD;
import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/java/Feature_Files/ProductOrdering.feature"},
        glue = {"Step_Definitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ParallelProductOrderRunnerTest extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    @Parameters("browserType")
//    public void beforeClass(String browserName) {
//        GWD.threadBrowserName.set(browserName);
//    }
}
