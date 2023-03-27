package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    public void findIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        searchInput.click();
        searchInput.setValue(repository).pressEnter();
        $(linkText(repository)).click();
        issueTab.click();
        $(withText(issueName)).should(exist);
    }
}
