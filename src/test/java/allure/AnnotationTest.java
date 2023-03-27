package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationTest extends TestBase {

    @Test
    public void testAnnotatedSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.searchForRepository(repository);
        steps.clickOnRepositoryLink(repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(issueName);
        steps.takeScreenshot();
    }
}
