package UI_tests.unstructed;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateWithAttribute {

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
        $("a[href=\"/data-sources\"]").click();
        $("span.Button-Label").click();

        // Выбираем формат
        $("div.AddDataSourceeModal-module_card_list_01S7mq3ZLF > div:nth-child(4)").shouldHave(text("Неструктурированный формат")).click();
        $("button[type=\"submit\"]").click();

        // Вводим название источника и описание
        $("input[placeholder=\"Название источника данных\"]").shouldBe(visible).click();
        $("input[placeholder=\"Название источника данных\"]").shouldBe(enabled).sendKeys("uf_test_auto_" + a.number().numberBetween(0, 100));
        $("textarea.TextField-Input").shouldBe(visible).click();
        $("textarea.TextField-Input").shouldBe(enabled).sendKeys("Description" + a.number().randomNumber());
        $("button[type=\"submit\"]").click();

        // Добавляем и заполняем атрибут с типом данных "Текст"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.0.name\"]").shouldBe(enabled).sendKeys("UserAttributeText");
        $("input[name=\"userAttribute.0.doc\"]").shouldBe(enabled).sendKeys("DescriptionText" + a.number().randomNumber());

        // Добавляем и заполняем атрибут с типом данных "Дата"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.1.type\"]").click();
        $("div.AddUserAttributes-module_option_item_active_JwkQ8h7FFo").click();
        $("input[name=\"userAttribute.1.name\"]").shouldBe(enabled).sendKeys("UserAttributeDate");
        $("input[name=\"userAttribute.1.doc\"]").shouldBe(enabled).sendKeys("DescriptionDate" + a.number().randomNumber());

        // Добавляем и заполняем атрибут с типом данных "Число"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.2.type\"]").click();
        $("div.AddUserAttributes-module_option_item_hovered_GRnVa6Hfpw").click();
        $("input[name=\"userAttribute.2.name\"]").shouldBe(enabled).sendKeys("UserAttributeNumber");
        $("input[name=\"userAttribute.2.doc\"]").shouldBe(enabled).sendKeys("DescriptionNumber" + a.number().randomNumber());

        // Добавляем источник
        $("button[type=\"submit\"]").click();
    }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
