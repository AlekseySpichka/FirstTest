package main;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.hc.client5.http.cookie.Cookie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ThirdTest {
    private static final Cookie COOKIE = new Cookie("appSession=b7e053b2846297382a2d65251c25c46f", "Path=/", "Expires=Wed, 07 Feb 2024 14:55:15 GMT", "HttpOnly", "Secure", "SameSite=Lax") {
        @Override
        public String getAttribute(String s) {
            return null;
        }

        @Override
        public boolean containsAttribute(String s) {
            return false;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public Date getExpiryDate() {
            return null;
        }

        @Override
        public boolean isPersistent() {
            return false;
        }

        @Override
        public String getDomain() {
            return null;
        }

        @Override
        public String getPath() {
            return null;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public boolean isExpired(Date date) {
            return false;
        }

        @Override
        public Date getCreationDate() {
            return null;
        }
    }

    @Before
    public void setup() {
        Configuration.browser = "chrome";

        Selenide.open("https://ndp-front-test.apps.okd.cloud.nedra.digital/data-sources");
    }

    @Test
    public void createUnstructedDataSource() {
        $("span.Button-Label").click();
        $("div.AddDataSourceeModal-module_card_list_01S7mq3ZLF > div:nth-child(4)").shouldHave(text("Неструктурированный формат")).click();
        $("button.Button_size_m.Button_view_primary").click();
        $("div.TextField_width_default > div > div > input").shouldBe(visible).click();
        $("div.TextField_width_default > div > div > input").shouldBe(enabled).sendKeys("uf_test_auto_0602");
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
