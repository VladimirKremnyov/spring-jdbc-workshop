package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.shop.dto.OrderDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    private final EntityManagerFactory entityManagerFactory;

    public OrdersRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<OrderEntity> findAllOrders() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from OrderEntity", OrderEntity.class).getResultList();
    }

    @Override
    public OrderEntity findOrderByID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(OrderEntity.class, id);
    }

    @Override
    public void addOrder(OrderDto orderDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(orderDto.toOrderEntity());
        transaction.commit();
    }

    @Override
    public void deleteOrder(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("delete from OrderEntity o where o.id=:orderId")
                .setParameter("orderId", id).executeUpdate();
        transaction.commit();
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderEntity newOrder = orderDto.toOrderEntity();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(newOrder);
        transaction.commit();
    }
}
