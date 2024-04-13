package Step_Definitions;

import Utilities.GWD;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @After
    public void after(Scenario senaryo) {
        if (senaryo.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
            byte[] hafizadakiHali = ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }

        GWD.quitDriver();
    }
}
