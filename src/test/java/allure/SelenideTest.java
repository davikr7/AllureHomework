package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("David Krasnov")
    @DisplayName("Тест для примера запуска Allure c Listener")
    public void findIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        searchInput.click();
        searchInput.setValue(repository).pressEnter();
        $(linkText(repository)).click();
        issueTab.click();
        $(withText(issueName)).should(exist);
    }
}
