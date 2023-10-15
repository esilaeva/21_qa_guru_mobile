package tests.ios;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    void successfulOpenArticle() throws MalformedURLException, InterruptedException {

        step("Click on the tab Newest", () -> {
            $(id("Newest")).click();
        });

//        step("Open article", () -> {
//            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
//        });

        //
        //Newest
        //Tux in the Ring [video]


        step("Verify content found", () -> {
            $(byText("Tux in the Ring [video]")).shouldBe(visible);
        });
    }
}
