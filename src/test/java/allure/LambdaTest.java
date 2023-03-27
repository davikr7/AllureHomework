package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("David Krasnov")
    @DisplayName("Тест для примера запуска Allure c Lambda Steps")
    public void testLambdaSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем github", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + repository, () -> {
            searchInput.click();
            searchInput.sendKeys(repository);
            searchInput.submit();
        });

        step("Кликаем по ссылке репозитория " + repository, () -> {
            $(linkText(repository)).click();
        });

        step("Открываем таб Issues", () -> {
            issueTab.click();
        });

        step("Проверяем наличие Issue с названием " + issueName, () -> {
            $(withText(issueName)).should(Condition.exist);
        });
    }
}
