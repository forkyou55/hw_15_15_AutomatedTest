package config;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverProvider {

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static void config() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);

        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;


        Configuration.baseUrl = WebDriverProvider.config.getBaseUrl();

        Configuration.browser = WebDriverProvider.config.getBrowser();

        Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();

        Configuration.browserSize = WebDriverProvider.config.getBrowserSize();

        String remoteUrl = WebDriverProvider.config.getRemote();

        if (remoteUrl != null) {

            Configuration.remote = remoteUrl;

        }


    }

}