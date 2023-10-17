package tests.ios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    @DisplayName("Check search result")
    void enterTextTest() {

        step("Click button Text", () -> {
            $(id("Text Button")).click();
        });

        step("Click 'Enter a text'", () -> {
            $(id("Text Input")).click();
        });

        step("Set text and press Enter", () -> {
            $(id("Text Input")).sendKeys("Appium");
            $(id("Text Input")).pressEnter();
        });

        step("Verify result", () -> {
            assertThat($(id("Text Output")).getText())
                    .isEqualTo("Appium");
        });
    }
}
