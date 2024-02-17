package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        Config config = ConfigFactory.create(Config.class, System.getProperties());

        // Set your access credentials
        caps.setCapability("browserstack.user", config.user());
        caps.setCapability("browserstack.key", config.key());

        // Set URL of the application under test
        caps.setCapability("app", config.app());

        // Specify device and os_version for testing
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.os());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}