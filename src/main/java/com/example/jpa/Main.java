package com.example.jpa;

import entity.TestTableEntity;
import jakarta.persistence.*;

import java.util.List;

//import jakarta.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("hdjfj");
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        TestTableEntity d= new TestTableEntity();
        try {
            transaction.begin();
//            TestTableEntity dataEntity=new TestTableEntity();
//            dataEntity.setNameTest("add of jpa");
//            entityManager.persist(dataEntity);

            Query q=entityManager.createNamedQuery("select");
            List<TestTableEntity> res = q.getResultList();
//            for(TestTableEntity testTableEntity :res){
//                System.out.println(testTableEntity.toString());
//            }
            d.update(res,14,"jpa update");
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