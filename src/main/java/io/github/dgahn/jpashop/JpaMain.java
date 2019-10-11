package io.github.dgahn.jpashop;

import io.github.dgahn.jpashop.domain.Book;
import io.github.dgahn.jpashop.domain.Item;
import io.github.dgahn.jpashop.domain.Order;
import io.github.dgahn.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Book book = new Book();
      book.setName("JPA");
      book.setAuthor("김영한");

      em.persist(book);

      Book book1 = em.find(Book.class, book.getId());
      System.out.println(book1.getId());

      tx.commit();
    }catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }

}
