package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class Auth {
    public static AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

    static {
            String remoteLogin = Auth.config.login();
        if (remoteLogin != null) {
                Configuration.remote = remoteLogin;

            String remotePassword = Auth.config.pass();
            if (remotePassword != null) {
                Configuration.remote = remotePassword;


            }
        }
    }
}
