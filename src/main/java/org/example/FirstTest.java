package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest {


    @Before
    public void setup() {
        Configuration.browser = "chrome";
        Selenide.open("https://market-delivery.yandex.ru/");
    }

    @Test
    public void firstTest() {
        SelenideElement button = $("#root > div > header > div > div.DesktopHeader_rightBlock > div > button > span");
        button.click();

    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
