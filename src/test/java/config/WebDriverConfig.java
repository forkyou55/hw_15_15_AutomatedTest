package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://mi-montenegro.me/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remote")
    String getRemote();




}