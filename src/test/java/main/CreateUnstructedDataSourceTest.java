package main;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateUnstructedDataSourceTest {

    Faker a = new Faker(Locale.ENGLISH);

    @Before
    public void setup() {
        Configuration.browser = "chrome";

        Selenide.open("https://ndp-front-test.apps.okd.cloud.nedra.digital/data-sources");
        $("#username").setValue("admin");
        $("#password").setValue("admin");
        $("#kc-login").click();
    }

    @Test
    public void createUnstructedDataSource() {
        $("div.Layout-module_container_8Mz53yHNml > header > ul > li:nth-child(2)").click();
        $("span.Button-Label").click();
        $("div.AddDataSourceeModal-module_card_list_01S7mq3ZLF > div:nth-child(4)").shouldHave(text("Неструктурированный формат")).click();
        $("button.Button_size_m.Button_view_primary").click();
        $("div.TextField_width_default > div > div > input").shouldBe(visible).click();
        $("div.TextField_width_default > div > div > input").shouldBe(enabled).sendKeys("uf_test_auto_" + a.number().randomNumber());
        $("button.Button_size_m.Button_view_primary.MixFocus").click();
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("div:nth-child(3) > div:nth-child(2) > div:nth-child(1) >div > div input").shouldBe(enabled).sendKeys("TestUserAttribute");
        $("button.Button_size_m.Button_view_primary.MixFocus").click();
    }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
