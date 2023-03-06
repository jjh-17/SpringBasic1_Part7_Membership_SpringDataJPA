package spring_basic.part7_membership_SpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_basic.part7_membership_SpringDataJPA.domain.Member;

import java.util.Optional;

//기본적인 함수들은 모두 자동으로 생성해서 스프링 빈으로 자동 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //단순 함수만으로 JPQL로 자동 해석
    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
