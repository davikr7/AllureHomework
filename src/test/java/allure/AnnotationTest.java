package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

   private String
            repository = "allure-framework/allure2",
            issueName = "Activate Cleanthat in Spotless";

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("David Krasnov")
    @DisplayName("Тест для примера запуска Allure c Annotation Steps")
    public void testAnnotatedSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.clickOnRepositoryLink(repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(issueName);
        steps.takeScreenshot();
    }
}
