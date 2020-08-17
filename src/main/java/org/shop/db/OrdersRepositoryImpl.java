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
    public List<OrderEntity> getOrderList() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from OrderEntity", OrderEntity.class).getResultList();
    }

    @Override
    public OrderEntity getOrderByID(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(OrderEntity.class, id);
    }

    @Override
    public void addOrderToDB(OrderDto orderDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(orderDto.toOrderEntity());
        transaction.commit();
    }

    @Override
    public void deleteOrderFromDB(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(orderEntity);
        transaction.commit();
    }
}
