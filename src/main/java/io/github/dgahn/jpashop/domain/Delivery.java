package io.github.dgahn.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Delivery {

  @Id @GeneratedValue
  private Long id;

  private String city;
  private String street;
  private String zipCode;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus status;

  @OneToOne(mappedBy = "delivery")
  private Order order;

}
