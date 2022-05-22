package com.tqtq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("simple")
public class SimpleTest {

    @Disabled
    @DisplayName("first")
    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
        Assertions.assertEquals(1, 2, "msg");
        Assertions.assertAll(
                () -> Assertions.assertTrue(3 > 2),
                () -> Assertions.assertEquals(1, 1)

        );
    }

    @DisplayName("second")
    @Test
    void secondTest() {
        Assertions.assertTrue(3 < 2);


    }
}
