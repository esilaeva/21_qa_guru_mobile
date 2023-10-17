package tests.ios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    @DisplayName("Find tab 'Newest'")
    void enterTextTest() {

        step("Click tab '\tNewest'", () -> {
            $(xpath("//*[@XCUIElementTypeStaticText='Newest']")).click();
        });

//        step("Нажать на поле Enter a text", () -> {
//            $(id("Text Input")).click();
//        });
//
//        step("Ввести в поле Enter a text текст Hello QA.GURU и нажать Enter", () -> {
//            $(id("Text Input")).sendKeys("Hello QA.GURU");
//            $(id("Text Input")).pressEnter();
//        });

        step("Verify that tab 'Newest' was opened", () -> {
            assertThat($(xpath("[XCUIElementTypeStaticText]")).getText())
                    .isEqualTo("1 points by marban");
        });
    }

    //Newest
    //	1 points by melenaboija
  //  XCUIElementTypeStaticText
   // Citibank wins case after sacking banker over two-sandwich lunch claim

//    @Test
//    @Tag("ios")
//    @DisplayName("Проверка ввода и отображения текста в UI Elements")
//    void secondTest() {
//
//        step("Нажать на кнопку Text", () -> {
//            $(id("Text Button")).click();
//        });
//
//        step("Нажать на поле Enter a text", () -> {
//            $(id("Text Input")).click();
//        });
//
//        step("Ввести в поле Enter a text текст Hello QA.GURU и нажать Enter", () -> {
//            $(id("Text Input")).sendKeys("Hello QA.GURU");
//            $(id("Text Input")).pressEnter();
//        });
//
//        step("Проверка отображения результата с заданным текстом", () -> {
//            assertThat($(id("Text Output")).getText())
//                    .isEqualTo("Hello QA.GURU");
//        });
//    }
}
