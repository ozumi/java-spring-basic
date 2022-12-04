package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void steatefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        // thread1 : A가 1000원 주문
        int price1 = service1.order("A", 1000);
        // thread2 : B가 500원 주문
        int price2 = service2.order("B", 500);
        // thread1 : A가 주문 조회
        //int price = service1.getPrice();
        System.out.println(price1);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}