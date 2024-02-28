package UI_tests.tests;

import UI_tests.enums.CardName;
import UI_tests.enums.SourceName;
import UI_tests.flows.DataSourceManagementFlow;
import org.junit.Test;



public class CreateDatasourceTest extends BaseTest {

    String filePath = "src/main/resouces/schema (1).xlsx";

    @Test
    public void createStructuredDatasourceTest() {
        new DataSourceManagementFlow()
                .clickListOfDataSources()
                .clickAddDataSource()
                .selectCard(CardName.STRUCTURED_FORMAT)
                .clickNextButton()
                .clickDataSourceNameInput()
                .enterDataSourceName(SourceName.STRUCTURED_FORMAT)
                .clickDescriptionInput()
                .enterDescriptionDataSource()
                .clickNextButton()
                .uploadFileInput(filePath)
                .clickNextButton()
                .clickSaveButton();
    }

    @Test
    public void createUnstructuredDatasourceTest() {
        new DataSourceManagementFlow()
                .clickListOfDataSources()
                .clickAddDataSource()
                .selectCard(CardName.UNSTRUCTURED_FORMAT)
                .clickNextButton()
                .clickDataSourceNameInput()
                .enterDataSourceName(SourceName.UNSTRUCTURED_FORMAT)
                .clickDescriptionInput()
                .enterDescriptionDataSource()
                .clickNextButton()
                .clickNextButton();
    }

    @Test
    public void createSpecializedDatasourceTest() {
        new DataSourceManagementFlow()
                .clickListOfDataSources()
                .clickAddDataSource()
                .selectCard(CardName.SPECIALIZED_FORMAT)
                .clickNextButton()
                .clickDataSourceNameInput()
                .enterDataSourceName(SourceName.SPECIALIZED_FORMAT)
                .clickDescriptionInput()
                .enterDescriptionDataSource()
                .clickNextButton();
    }

    @Test
    public void createStreamingDatasourceTest() {
        new DataSourceManagementFlow()
                .clickListOfDataSources()
                .clickAddDataSource()
                .selectCard(CardName.STREAMING_DATA)
                .clickNextButton()
                .clickDataSourceNameInput()
                .enterDataSourceName(SourceName.STREAMING_DATA)
                .clickDescriptionInput()
                .enterDescriptionDataSource()
                .clickNextButton()
                .uploadFileInput(filePath)
                .clickNextButton()
                .clickSaveButton();
    }
}
