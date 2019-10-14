package io.github.dgahn.jpashop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  //  @Column(name = "MEMBER_ID")
//  private Long memberId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 주문 입장에서 하나의 멤버가 여러개의 주문을 함.
  @JoinColumn(name = "MEMBER_ID") // 외래키로 멤버의 멤버아이디를 가지고 있음
  private Member member;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(final Member member) {
    this.member = member;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(final LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(final OrderStatus status) {
    this.status = status;
  }

  public void addOrderItem(final OrderItem orderItem) {
    orderItems.add(orderItem);
    orderItem.setOrder(this);
  }

}
