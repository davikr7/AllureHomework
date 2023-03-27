package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebSteps extends TestBase {

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        searchInput.click();
        searchInput.sendKeys(repo);
        searchInput.submit();
    }
    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        issueTab.click();
    }
    @Step("Проверяем наличие Issue с названием {issue}")
    public void shouldSeeIssueWithName(String issue) {
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
