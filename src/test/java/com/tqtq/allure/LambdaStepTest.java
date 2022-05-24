package com.tqtq.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
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
        step("открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("вводим репозиторий" + REPOSITORY, () -> {
            $("input[name=q]").
                    setValue(REPOSITORY).
                    pressEnter();
        });
        step("переходим по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).
                    click();
        });
        step("кликаем на Issues", () -> {
            $(partialLinkText("Issues")).
                    click();
        });
        step("ищем issue "+ISSUE_NUMBER, () -> {
            $(withText("#"+ISSUE_NUMBER)).
                    click();
        });


    }

}
