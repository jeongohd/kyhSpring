package kyh.spring.xml;

import kyh.spring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {
    @Test
    void xmlAppContext() {
//        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");// resources 하위 파일을 저절로 읽음.
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
