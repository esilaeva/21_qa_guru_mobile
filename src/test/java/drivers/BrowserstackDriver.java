package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    protected static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
    protected static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        mutableCapabilities.setCapability("browserstack.user", authConfig.getUserName());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getAccessKey());
        mutableCapabilities.setCapability("app", config.getApp());
        mutableCapabilities.setCapability("deviceName", config.getDeviceName());
        mutableCapabilities.setCapability("platformVersion", config.getVersion());

        mutableCapabilities.setCapability("platformName", config.getPlatformName());
        mutableCapabilities.setCapability("projectName", config.getProject());
        mutableCapabilities.setCapability("build", config.getBuild());
        mutableCapabilities.setCapability("name", config.getTestName());

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getRemoteUrl()), mutableCapabilities);
//                    new URL("https://hub.browserstack.com/wd/hub"), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
