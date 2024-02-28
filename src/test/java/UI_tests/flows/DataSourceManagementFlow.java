package UI_tests.flows;

import UI_tests.enums.CardName;
import UI_tests.enums.SourceName;


import java.io.File;

import static UI_tests.helpers.DataHelper.getDescription;
import static UI_tests.helpers.DataHelper.getSourceName;
import static UI_tests.pages.DataSourceManagementPage.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;

public class DataSourceManagementFlow {

    public DataSourceManagementFlow clickListOfDataSources() {
        listOfDataSources.click();
        return this;
    }

    public DataSourceManagementFlow clickAddDataSource() {
        addDataSource.click();
        return this;
    }

    public DataSourceManagementFlow selectCard(CardName cardName) {
        addDataSourceModalWindowCards.get(cardName.getIndex()).shouldHave(text(cardName.getText())).shouldBe(enabled).click();
        return this;
    }

    public DataSourceManagementFlow clickNextButton() {
        nextButton.click();
        return this;
    }

    public DataSourceManagementFlow clickDataSourceNameInput() {
        dataSourceNameInput.shouldBe(visible).click();
        return this;
    }

    public DataSourceManagementFlow enterDataSourceName(SourceName sourceName) {
        dataSourceNameInput.shouldBe(enabled).sendKeys(getSourceName(sourceName));
        return this;
    }

    public DataSourceManagementFlow clickDescriptionInput() {
        dataSourceDescriptionInput.shouldBe(visible).click();
        return this;
    }

    public DataSourceManagementFlow enterDescriptionDataSource() {
        dataSourceDescriptionInput.shouldBe(enabled).sendKeys(getDescription());
        return this;
    }

    public DataSourceManagementFlow uploadFileInput(String filePath) {
        uploadFileInput.uploadFile(new File(filePath));
        return this;
    }

    public DataSourceManagementFlow clickSaveButton() {
        nextButton.shouldBe(enabled).click();
        return this;
    }
}
