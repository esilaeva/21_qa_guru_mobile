package tests.ios;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    void successfulOpenArticle() throws MalformedURLException, InterruptedException {

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
        });

        step("Open article", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });

        //
        // /XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeButton
        // /XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeLink/XCUIElementTypeStaticText

        // Selenidera Selenide iodide
        //        org.wikipedia.alpha:id/page_list_item_title
//        org.wikipedia.alpha:id/view_wiki_error_text
//        An error occurred

        step("Verify content found", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text("An error occurred"));
        });
    }
}
