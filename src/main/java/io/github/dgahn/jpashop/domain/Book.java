package io.github.dgahn.jpashop.domain;


import javax.persistence.Entity;


@Entity
public class Book extends Item {

  private String author;
  private String isbn;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

}
