package spring_basic.part7_membership_SpringDataJPA.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//고객 데이터 - 아이디, 이름
@Entity //이 클래스는 JPA가 관리한다 : JPA 엔티티 매핑
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY : DB가 Id 자동 생성
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
