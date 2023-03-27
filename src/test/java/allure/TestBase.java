package allure;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {
    SelenideElement
            searchInput = $(".header-search-input"),
            issueTab = $("#issues-tab");
    String
            repository = "allure-framework/allure2",
            issueName = "Activate Cleanthat in Spotless";

}
