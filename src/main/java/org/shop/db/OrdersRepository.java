package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
@Repository
public class OrdersRepository {

    private final EntityManagerFactory entityManagerFactory;

    public OrdersRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    public List<OrderEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("FROM OrderEntity", OrderEntity.class).getResultList();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        List<OrderEntity> ordersRepository = context.getBean("ordersRepository", OrdersRepository.class).findAll();
        System.out.println(ordersRepository);
    }
}
