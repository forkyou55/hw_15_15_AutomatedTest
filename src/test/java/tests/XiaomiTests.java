package tests;


import config.Auth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.XiaomiPages;


public class XiaomiTests extends TestBase {
    XiaomiPages xiaomiPage = new XiaomiPages();

    @Test
    @DisplayName("Check menu item name")
    void checkMenuItems() {
        xiaomiPage
                .openPage()
                .checkMenuItems();
    }

    @Test
    @DisplayName("Checking cleaner in stock")
    void cleanerSearchTest() {
        xiaomiPage
                .openPage()
                .search("usisivac")
                .checkInSearchResults("Xiaomi Robot usisivač Mop 2 Lite");
    }

    @Test
    @DisplayName("Add and remove item in bag")
    void bagTest() {
        xiaomiPage
                .openPage()
                .addItemInBag();
    }

    @ValueSource(strings = {"Prodavnica", "Moj nalog", "Politika privatnosti", "Opšte Odredbe",
            "Uputstvo za kupovinu", "Novosti"})
    @ParameterizedTest(name = "Footer Test")
    @DisplayName("Checking footer selection")
    void countrySearchTest(String testFooter) {
        xiaomiPage
                .openPage()
                .setCheckFooter(testFooter);
    }
    @Test
    @DisplayName("Authorization account test")
    void authorizationTests() {
        xiaomiPage
                .openPage()
                .LoginWith(Auth.config.login(), Auth.config.pass());
    }
}