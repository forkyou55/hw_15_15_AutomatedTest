package pages;

import com.codeborne.selenide.SelenideElement;
import config.Auth;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class XiaomiPages {

    private SelenideElement

            phoneButton = $("#menu-item-4570"),
            smartButton = $("#menu-item-4571"),
            scooterButton = $("#menu-item-4572"),
            lifeButton = $("#menu-item-4569"),
            audioButton = $("#menu-item-4568"),
            tvButton = $("#menu-item-4573"),
            accessoriesButton = $("#menu-item-4567"),
            camButton = $("#menu-item-4574"),
            saleButton = $("#menu-item-5516"),
            searchButton = $(".mpst-search"),
            searchInput = $(".search-field"),
            searchResultCleaner = $("#post-2177"),
            preLinkMenu = $("#menu-item-5516"),
            linkMenu = $(byText("Eko system i ostali uređaji")),
            addItem = $(".cta"),
            bagDirectory = $(".wcmenucart-contents"),
            removeItem = $(".product-remove"),
            authUser = $(By.xpath("//i[@class='las fa-user-plus']")),
            authButton = $(By.xpath("//button[@type='submit']")),
            checkAuth = $(".woocommerce-MyAccount-content"),
            checkFooter = $("#pgc-w6343edf3bd900-0-1");

    private final SelenideElement emailInput = $("#username");
    private final SelenideElement passInput = $("#password");

    public XiaomiPages openPage() {
        step("Open 'https://mi-montenegro.me/'", () ->
                open("https://mi-montenegro.me/"));
        return this;
    }

    public void checkMenuItems() {
        step("Check menu item name 'Mobilni telefoni'", () ->
                phoneButton.shouldHave(text("Mobilni telefoni")));
        step("Check menu item name 'Smart home'", () ->
                smartButton.shouldHave(text("Smart home")));
        step("Check menu item name 'Trotineti'", () ->
                scooterButton.shouldHave(text("Trotineti")));
        step("Check menu item name 'Lifestyle'", () ->
                lifeButton.shouldHave(text("Lifestyle")));
        step("Check menu item name 'Audio'", () ->
                audioButton.shouldHave(text("Audio")));
        step("Check menu item name 'TV'", () ->
                tvButton.shouldHave(text("TV")));
        step("Check menu item name 'Aksesoari'", () ->
                accessoriesButton.shouldHave(text("Aksesoari")));
        step("Check menu item name 'Video'", () ->
                camButton.shouldHave(text("Video")));
        step("Check menu item name 'Akcijski proizvodi'", () ->
                saleButton.shouldHave(text("Akcijski proizvodi")));

    }

    public XiaomiPages search(String text) {
        step("Click search button", () ->
                searchButton.click());
        step("Enter text for input", () ->
                searchInput.setValue(text)).pressEnter();
        return this;
    }

    public void checkInSearchResults(String headerText) {
        step("Checking in stock", () ->
                searchResultCleaner.shouldHave(text(headerText)));

    }

    public void addItemInBag() {
        step("Hover button sale", () ->
                preLinkMenu.hover());
        step("Click by button sale", () ->
                linkMenu.click());
        step("Add item in bag", () ->
                addItem.shouldHave(text("Kupi odmah"))).click();
        step("Check bag directory", () ->
                bagDirectory.click());
        step("Remove item", () ->
                removeItem.click());

    }

    @Step("Login with {username}/{password}")
    public void LoginWith() {
        step("Click by authorization button", () ->
                authUser.click());
        step("Enter username", () ->
                emailInput.sendKeys(Auth.config.getLogin()));
        step("Enter password", () ->
                passInput.sendKeys(Auth.config.getPass()));
        step("Click by enter button", () ->
                authButton.click());
        step("Check text", () ->
                checkAuth.shouldHave(text("\n" +
                        "\tIz svoje nadzorne ploče možete pregledati svoje ")));
    }

    public void setCheckFooter(String testFooter) {
        step("Checking footer selection", () ->
                checkFooter.shouldHave(text(testFooter)));
    }
}