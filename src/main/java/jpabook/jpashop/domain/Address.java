package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable //jpa의 내장 타입 - 어딘가에 내장될수있도록
@Getter @Setter
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
