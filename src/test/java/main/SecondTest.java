package main;

import com.codeborne.selenide.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SecondTest {


    @Before
    public void setup() {
        Configuration.browser = "chrome";
        Selenide.open("https://market-delivery.yandex.ru/");
    }

    @Test
    public void firstTest() {
        $("button.Profile_button").click();
        $("a[aria-label='Яндекс']").shouldBe(exist);
        $("button[data-type='phone']").shouldHave(text("Телефон")).click();
        $("span.Textinput > input").shouldBe(visible).click();
        $("span.Textinput > input").shouldBe(visible).sendKeys("1111111111");
        $("button[id='passp:sign-in']").shouldBe(enabled).click();
        String hint = $("div[id='field:input-phone:hint']").getText();
        Assert.assertEquals("Недопустимый формат номера", hint);
        }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }


}
