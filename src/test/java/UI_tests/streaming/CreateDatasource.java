package UI_tests.streaming;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateDatasource {

    Faker a = new Faker(Locale.ENGLISH);
    String filePath = "src/main/resouces/wellpredictarray.avsc";

    @Before
    public void setup() {
        Configuration.browser = "chrome";

        Selenide.open("https://ndp-front-test.apps.okd.cloud.nedra.digital/data-sources");
        $("#username").setValue("admin");
        $("#password").setValue("admin");
        $("#kc-login").click();
    }

    @Test
    public void createStreamingDatasource() {
        $("a[href=\"/data-sources\"]").click();
        $("span.Button-Label").click();

        //Выбираем формат
        $("div.AddDataSourceeModal-module_card_list_01S7mq3ZLF > div:nth-child(1)").shouldHave(text("Потоковая передача данных")).click();
        $("button[type=\"submit\"]").click();

        //Вводим название источника и описание
        $("input[placeholder=\"Название источника данных\"]").shouldBe(visible).click();
        $("input[placeholder=\"Название источника данных\"]").shouldBe(enabled).sendKeys("str_test_auto_" + a.number().numberBetween(0, 100));
        $("textarea.TextField-Input").shouldBe(visible).click();
        $("textarea.TextField-Input").shouldBe(enabled).sendKeys("Description" + a.number().randomNumber());
        $("button[type=\"submit\"]").click();

        //Загружаем файл
        $("Input[type=\"file\"]").uploadFile(new File(filePath));
        $("button[type=\"submit\"]").click();

        //Добавляем источник
        $("button[type=\"submit\"]").click();
    }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}

