package com.tqtq;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.tqtq.domain.MenuItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("WebTest")
public class WebTest {
    @CsvSource(value = {
            "Selenide|is really nice and capable tool",
            "Junit|team’s statement on the war"},
            delimiter = '|')


    @ParameterizedTest(name = "Test ya for word {0} res {1}")
    void yaSearchTest(String testData,
                      String expectedResult) {
        open("https://ya.ru");
        $("input.input__control[name=text]").setValue(testData);
        $("button.button[role=button]").click();

        $$("div.main__center").
                find(text(expectedResult)).
                shouldBe(visible);
    }

    static Stream<Arguments> methodSourceExample() {
        return Stream.of(
                Arguments.of("first str", List.of(42, 13)),
                Arguments.of("second str", List.of(2, 3))

        );
    }

    @MethodSource("methodSourceExample")
    @ParameterizedTest
    void methodSourceExample(String first, List<Integer> second) {
        System.out.println(first + " list " + second);
    }


    //
    @EnumSource(MenuItem.class)
    @ParameterizedTest()
    void yaSearchMenuTest(MenuItem testData) {
        open("https://ya.ru");
        $("input.input__control[name=text]").setValue("Allure");
        $("button.button[role=button]").click();

        $$(".navigation__item").
                find(text(testData.rusName)).
                click();

        Assertions.assertEquals(2,
                WebDriverRunner.getWebDriver().getWindowHandles().size());
    }
    @AfterEach
    void close(){
        Selenide.closeWebDriver();
    }
}

