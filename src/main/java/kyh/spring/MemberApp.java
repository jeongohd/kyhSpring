package kyh.spring;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//      MemberService memberService = new MemberServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        /**
            ★ BeanFactory(interface) <- ApplicationContext(interface) <- AnnotationConfigApplicationContext(구현체)


            ApplicationContext 스프링 컨테이너(Interface)
            AppConfig 환경설정정보를 가지고 스프링컨테이너에 넣어 관리.

            Spring은 빈을 모두 생성하고 의존관계를 주입한다.
         **/
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "ojg", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
