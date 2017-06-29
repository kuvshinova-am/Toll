package jdev.tracker.core;

import jdev.tracker.core.services.InjectionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);
    }
}
