package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBin.class);
    }

    static class TestBin {
        //Member는 스프링빈이 아니다
        //주입할 bean이 없으면 수정자메서드 자체가 호출이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean) {
            System.out.println("noBean 1 = " + noBean);
        }

        //주입할 bean이 없으면 null이 입력됨
        @Autowired
        public void setNoBean2(@Nullable Member noBean) {
            System.out.println("noBean 2 = " + noBean);
        }

        //JAVA8 : 주입할 bean이 없으면 Optional.empty가 입력됨
        @Autowired
        public void setNoBean3(Optional<Member> noBean) {
            System.out.println("noBean 3 = " + noBean);
        }
    }
}
