package kyh.spring;

import kyh.spring.member.Grade;
import kyh.spring.member.Member;
import kyh.spring.member.MemberService;
import kyh.spring.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

//      MemberService memberService = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();


        Member member = new Member(1L, "ojg", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
