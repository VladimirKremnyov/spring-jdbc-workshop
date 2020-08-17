package org.shop.db;

import org.shop.db.entity.OrderDetailEntity;
import org.shop.db.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    private final EntityManagerFactory entityManagerFactory;

    public OrderDetailsRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<OrderDetailEntity> getOrderDetailList(Long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from OrderDetailEntity where orderID=:orderID")
                .setParameter("orderID", orderId).getResultList();
    }

    @Override
    public OrderDetailEntity getDetailByID(Long detailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(OrderDetailEntity.class, detailId);
    }

    @Override
    public void addDetailToOrder(Long orderId, OrderDetailEntity orderDetail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
        orderEntity.getOrderDetailEntities().add(orderDetail);
        transaction.begin();
        entityManager.persist(orderEntity);
        transaction.commit();
    }

    @Override
    public void deleteDetailFromOrder(Long detailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderDetailEntity orderDetailEntity = entityManager.find(OrderDetailEntity.class, detailId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(orderDetailEntity);
        transaction.commit();
    }
}
