package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServieImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServieImpl();
        Member member = new Member(1L, "Juyoung", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.getName());
        System.out.println(findMember.getName());
    }
}
