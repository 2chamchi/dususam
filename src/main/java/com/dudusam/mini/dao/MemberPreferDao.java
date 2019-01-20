package com.dudusam.mini.dao;


import com.dudusam.mini.domains.MemberPreferenceVO;
import com.dudusam.mini.domains.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

@Repository("MemberPreferDao")
public class MemberPreferDao {

    @Autowired
    @Qualifier("jpaSessionFactoryBean")
    private EntityManagerFactory entityManagerFactory;

    public int addUser(MemberPreferenceVO memberPreferenceVO) {
        int result = 0;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(memberPreferenceVO);
            transaction.commit();
            result = 1;
        }catch (PersistenceException e){
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            entityManager.close();
        }
        return result;
    }

    public int updateUser(MemberVO memberVO) {
        return 0;
    }

    public int deleteUser(MemberVO memberVO) {
        return 0;
    }
}
