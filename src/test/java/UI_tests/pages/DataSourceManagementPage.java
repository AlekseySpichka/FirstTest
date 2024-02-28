package UI_tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class DataSourceManagementPage {

    public static SelenideElement listOfDataSources = $("a[href=\"/data-sources\"]");
    public static SelenideElement addDataSource = $("span.Button-Label");
    public static ElementsCollection addDataSourceModalWindowCards = $$("div.Modal-Window div.MixCard_form_round");
    public static SelenideElement nextButton = $("button[type=\"submit\"]");
    public static SelenideElement dataSourceNameInput = $("input[placeholder=\"Название источника данных\"]");
    public static SelenideElement dataSourceDescriptionInput = $("textarea.TextField-Input");
    public static SelenideElement uploadFileInput = $("Input[type=\"file\"]");

}
