package com.tqtq.junit;

import com.tqtq.SimpleTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.text.DefaultEditorKit;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.platform.commons.util.ReflectionUtils.getDeclaredConstructor;

public class SimpleJunit {

    public static void main(String[] args) throws Exception {
        // находит классы с тестами
        Method[] declaredMethods = SimpleTest.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            // смотрит где @Test
            Test testAnnotation = method.getAnnotation(Test.class);
            Disabled disabledAnnotation = method.getAnnotation(Disabled.class);

            if (testAnnotation != null && disabledAnnotation == null) {
                // запускает
                try {
                    method.invoke(SimpleTest.class.getDeclaredConstructor().newInstance());
                    // если не упал, то все ок

                } catch (InvocationTargetException e) {
                    // если тест упал - сообщает
                    System.out.println("Test failed " + e.getCause().getMessage());
                    throw e;
                }
            }
        }


    }
}
