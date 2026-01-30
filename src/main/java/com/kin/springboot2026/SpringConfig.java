package com.kin.springboot2026;

import com.kin.springboot2026.repository.JdbcMemberRepository;
import com.kin.springboot2026.repository.JdbcTemplateMemberRepository;
import com.kin.springboot2026.repository.MemberRepository;
import com.kin.springboot2026.repository.MemoryMemberRepository;
import com.kin.springboot2026.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration //스프링이 뜰때 이 설정 파일을 읽음
public class SpringConfig {
    
    //Controller는 어쩔수 없음

    private DataSource dataSource;

    @Autowired //datasource는 application.properties 파일의 db정보를 바탕으로 이미 컨테이너에서 객체로 가지고 있음.
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean // memberService()함수의 리턴값을 bean으로 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
