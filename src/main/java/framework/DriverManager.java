package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static constants.Config.BROWSER_TO_OPEN;
import static constants.WaitTimeouts.IMPLICIT_WAIT;

public class DriverManager {
    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    private static void setWebDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static void startBrowser() {
        setWebDriver(Driver.getByDriverType(BROWSER_TO_OPEN)
                .getWebDriverCreator()
                .create());
    }

    public synchronized static WebDriver getWebDriver() {
        if (driver.get() == null) {
            startBrowser();
        }
        return driver.get();
    }

    public synchronized static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }
}
