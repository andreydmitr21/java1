package com.tqtq.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure-selenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        open("https://github.com");
        $("input[name=q]").
                setValue("eroshenkoam/allure-example").
                pressEnter();
        $(linkText("eroshenkoam/allure-example")).
                click();
//        $("#issues-tab").
//                click();
        $(partialLinkText("Issues")).
                click();
        $(withText("#796")).
                click();



    }

}
