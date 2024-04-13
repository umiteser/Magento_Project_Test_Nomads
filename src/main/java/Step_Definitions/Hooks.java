package Step_Definitions;

import Utilities.GWD;
import io.cucumber.shaded.messages.types.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
  @After
  public void after(Scenario senaryo) {
      if (senaryo.()) {
          TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
          byte[] hafizadakiHali = ts.getScreenshotAs(OutputType.BYTES);
          senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
      }

      GWD.quitDriver();
    }
}