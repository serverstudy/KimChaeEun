package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable //jpa의 내장 타입 - 어딘가에 내장될수있도록
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // 기본 생성자 필요함 - public은 많이 호출되니까 protected로한다.
    }

    // 값 타입은 생성될 시에만 값이 세팅되도록! 수정불가능하게
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
