package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public List<OrderEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("FROM OrderEntity", OrderEntity.class).getResultList();
    }

    public OrderEntity update(long orderId, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        orderEntity.setName(name);
        transaction.commit();
        return orderEntity;
    }

    public OrderEntity findById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String query=" select t from OrderEntity  t where t.id="+id;
        return entityManager.createQuery(query, OrderEntity.class).getSingleResult();
    }

    public void saveOrder(OrderEntity orderEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(orderEntity);
        transaction.commit();
    }

    public void deleteOrder(OrderEntity orderEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(orderEntity) ? orderEntity : entityManager.merge(orderEntity));
        transaction.commit();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        OrdersRepository ordersRepository = context.getBean("ordersRepository", OrdersRepository.class);
        List<OrderEntity> orderEntities = ordersRepository.findAll();
        System.out.println(orderEntities.toString());



    }
}
