package com.example.basic.domain.entity;

import com.example.basic.repository.MemberRepository;
import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)

public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveTest(){
        Member member = new Member();
        member.create("박종우","jwp9701242","1234",26, MemberType.MEMBER);
        Member member1 = new Member();
        member.create("박종혁","jwp9701243","1234",26, MemberType.MEMBER);
        memberRepository.save(member);
        memberRepository.save(member1);
    }

    @Test
    public void findByIdTest(){
        assertThat(memberRepository.findById(1l)).isNotEmpty();
    }

    @Test
    public void findAllTest(){
        memberRepository.findAll().stream().map(Member::toString).forEach(log::info);
    }

    @Test
    public void update(){
        memberRepository.findById(1l).get().setMemberPassword("0001");
        memberRepository.deleteById(1l);
    }

    @Test
    public void delete(){
        memberRepository.deleteAll();
    }

    @Test
    public void findByTest(){
        memberRepository.findByMemberNameContaining("박").stream().map(Member::toString).forEach(log::info);
    }


}
