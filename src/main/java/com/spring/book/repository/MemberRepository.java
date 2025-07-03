package com.spring.book.repository;

import com.spring.book.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserEmail(String userEmail);
}
