package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public ChromeDriver create() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        return new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("enable-features=NetworkServiceInProcess"));
    }
}
