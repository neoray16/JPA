package com.example.jpa;

import entity.TestTableEntity;
import jakarta.persistence.*;

//import jakarta.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("hdjfj");
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        try {
            transaction.begin();
            TestTableEntity dataEntity=new TestTableEntity();
            dataEntity.setNameTest("add of jpa");
            entityManager.persist(dataEntity);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}