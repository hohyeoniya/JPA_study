package com.example.basic.repository;


import com.example.basic.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public List<Member> findByMemberNameContaining(String name);
}
