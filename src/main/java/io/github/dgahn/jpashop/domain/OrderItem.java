package io.github.dgahn.jpashop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ITEM_ID")
  private Item item;

//  @Column(name = "ORDER_ID")
//  private Long orderId;
//
//  @Column(name = "ITEM_ID")
//  private Long itemId;

  private int orderPrice;
  private int count;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(final Item item) {
    this.item = item;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(final int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public int getCount() {
    return count;
  }

  public void setCount(final int count) {
    this.count = count;
  }

}
