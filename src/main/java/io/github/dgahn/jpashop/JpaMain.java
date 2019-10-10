package io.github.dgahn.jpashop;

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

      Order order = new Order();
      order.addOrderItem(new OrderItem());


      tx.commit();
    }catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }

}
