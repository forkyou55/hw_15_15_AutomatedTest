package config;


import org.aeonbits.owner.ConfigFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class Auth {
    public static AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

    static {
//        String remoteLogin = Auth.config.login();
//        if (remoteLogin != null) {
//            Configuration.remote = remoteLogin;
//
//            String remotePassword = Auth.config.pass();
//            if (remotePassword != null) {
//                Configuration.remote = remotePassword;
        validateProperty(config.getLogin(), "username");
        validateProperty(config.getPass(), "password");
        }
    public static void validateProperty (String propertyValue, String propertyName){
        assertThat(propertyValue)
                .withFailMessage("'%s' value is null or empty", propertyName)
                .isNotEmpty();
    }
}