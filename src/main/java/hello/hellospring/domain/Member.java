package hello.hellospring.domain;

public class Member {

    private Long id; //id 식별자
    // 임의의 값 : 데이터를 구분하기 위해서 고객이 저장하는 ID가 아닌 시스템이 저장하는 ID
    private String name; //이름

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
