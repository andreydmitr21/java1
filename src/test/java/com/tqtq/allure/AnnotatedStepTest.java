package com.tqtq.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedStepTest {
    //    @BeforeAll
//    static void start(){
//        SelenideLogger.addListener("allure-selenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true));
//    }

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "76";
    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        WebSteps steps= new WebSteps();
        steps.openSite();
        steps.searchRepo(REPOSITORY);
        steps.clickRepo(REPOSITORY);
        steps.attachScreenShot();
        steps.openIssues();
        Allure.getLifecycle().addAttachment("PageSourxe",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
        steps.selectIssue(ISSUE_NUMBER);

    }
}
