package framework;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public EdgeDriver create() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\msedgedriver.exe");
        return new EdgeDriver();
    }
}
