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

    static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUserName());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getAccessKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", config.getApp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("deviceName", config.getDeviceName());
        mutableCapabilities.setCapability("platformVersion", config.getPlatformVersion());
        mutableCapabilities.setCapability("platformName", config.getPlatformName());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("projectName", config.getProject());
        mutableCapabilities.setCapability("build", config.getBuild());
        mutableCapabilities.setCapability("name", config.getTestName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
