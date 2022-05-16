package hello.hellospring.domain;
//jpa를 쓰려면 entity를 맵핑해야함
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * jpa : 인터페이스만 제공이 됨
 * 하이버네이트등의 여러가지 구현체가 있다.
 * jpa는 자바 인터페이스의 표준이고 구현은 여러 업체들이 하는 것
 *
 * jpa는 객체랑 ORM 이라는 기술
 * ORM : Object, Relaitional, Mapping
 *
 * */
@Entity
public class Member {
    // Primary Key 생성 방식 :
    // DB가 ID값을 자동으로 생성해 주는 것을 아이텐티티 전략이라고 한다.
    // Oracle은 시퀀스
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) { //id 식별자
        // 임의의 값 : 데이터를 구분하기 위해서 고객이 저장하는 ID가 아닌 시스템이 저장하는 ID
        this.id = id;
    }
    public String getName() { // 이름
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}