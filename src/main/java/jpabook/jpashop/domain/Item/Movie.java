package jpabook.jpashop.domain.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
@Getter
@Setter
public class Movie extends Item { //Item을 상속받음
    private String director;
    private String actor;
}
