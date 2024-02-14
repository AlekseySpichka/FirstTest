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

public class CreateWithAtribute {

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
    public void createUnstructuredDatasource() {
        $("a[href=\"/data-sources\"]").click();
        $("span.Button-Label").click();


        // Выбираем формат
        $("div.AddDataSourceeModal-module_card_list_01S7mq3ZLF > div:nth-child(4)").shouldHave(text("Неструктурированный формат")).click();
        $("button[type=\"submit\"]").click();

        // Вводим название источника и описание
        $("input[placeholder=\"Название источника данных\"]").shouldBe(visible).click();
        $("input[placeholder=\"Название источника данных\"]").shouldBe(enabled).setValue("uf_test_auto_" + a.number().numberBetween(0, 100));
        String fileName = $("input[placeholder=\"Название источника данных\"]").getValue();
        $("textarea.TextField-Input").shouldBe(visible).click();
        $("textarea.TextField-Input").shouldBe(enabled).sendKeys("Description" + a.number().randomNumber());
        $("button[type=\"submit\"]").click();

        // Добавляем и заполняем атрибут с типом данных "Текст"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.0.name\"]").shouldBe(enabled).sendKeys("UserAtributeText");
        $("input[name=\"userAttribute.0.doc\"]").shouldBe(enabled).sendKeys("DescriptionText" + a.number().randomNumber());

        // Добавляем и заполняем атрибут с типом данных "Дата"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.1.type\"]").click();
        $("div:nth-child(2) > img[src=\"/assets/type_date-94237ab8.svg\"]").click();
        $("input[name=\"userAttribute.1.name\"]").shouldBe(enabled).sendKeys("UserAtributeDate");
        $("input[name=\"userAttribute.1.doc\"]").shouldBe(enabled).sendKeys("DescriptionDate" + a.number().randomNumber());

        // Добавляем и заполняем атрибут с типом данных "Число"
        $("div:nth-child(4) > button").shouldBe(visible).click();
        $("input[name=\"userAttribute.2.type\"]").click();
        $("div:nth-child(3) > img[src=\"/assets/type_number-b6c6ab9e.svg\"]").click();
        $("input[name=\"userAttribute.2.name\"]").shouldBe(enabled).sendKeys("UserAtributeNumber");
        $("input[name=\"userAttribute.2.doc\"]").shouldBe(enabled).sendKeys("DescriptionNumber" + a.number().randomNumber());

        // Добавляем источник
        $("button[type=\"submit\"]").click();

        System.out.println("File name: " + fileName);
        $("a[href=\"/data-sources\"]").click();
        $("div:nth-child(10) > div:nth-child(1) > div > div > div").shouldHave(text(fileName)).find("div:nth-child(10) > div:nth-child(7) > div > div > div > button:nth-child(2)").click();;

    }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
