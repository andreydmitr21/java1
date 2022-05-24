package com.tqtq.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {


    @Step("открываем главную страницу")
    public void openSite() {
        open("https://github.com");
    }


    @Step("вводим репозиторий {repo}")
    public void searchRepo(String repo) {
        $("input[name=q]").
                setValue(repo).
                pressEnter();
    }

    @Step("переходим по ссылке репозитория {repo}")
    public void clickRepo(String repo) {
        $(linkText(repo)).
                click();
    }

    @Step("кликаем на Issues")
    public void openIssues() {
        $(partialLinkText("Issues")).
                click();
    }

    @Step("ищем issue {issu}")
    public void selectIssue(String issu) {
        $(withText("#"+issu)).
                should(Condition.visible);
    }



}

