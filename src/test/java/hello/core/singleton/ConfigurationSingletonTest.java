package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository mr1 = memberService.getMemberRepository();
        MemberRepository mr2 = orderService.getMemberRepository();

        System.out.println("MemberService : " + mr1);
        System.out.println("OrderService : " + mr2);
        System.out.println("MemberRepository : " + memberRepository);

        assertThat(mr1).isSameAs(memberRepository);
        assertThat(mr2).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean : " + bean.getClass());
        //출력 : bean : class hello.core.AppConfig$$EnhancerBySpringCGLIB$$ed189d5f
        //스프링이 CGLIB라는 바이트 조작 라이브러리를 사용해 임의의 클래스를 만든 것
    }
}
