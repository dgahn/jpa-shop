package io.github.dgahn.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Item extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "ITEM_ID")
  private Long id;

  private String name;
  private int price;
  private int stockQuantity;

  @ManyToMany(mappedBy = "items")
  private List<Category> categories = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(final int price) {
    this.price = price;
  }

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(final int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

}
