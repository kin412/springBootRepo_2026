package com.kin.springboot2026;

import com.kin.springboot2026.repository.MemberRepository;
import com.kin.springboot2026.repository.MemoryMemberRepository;
import com.kin.springboot2026.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링이 뜰때 이 설정 파일을 읽음
public class SpringConfig {
    
    //Controller는 어쩔수 없음

    @Bean // memberService()함수의 리턴값을 bean으로 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
