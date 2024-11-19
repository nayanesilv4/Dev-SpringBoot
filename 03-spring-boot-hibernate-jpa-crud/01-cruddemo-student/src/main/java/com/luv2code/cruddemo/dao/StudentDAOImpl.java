package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // definir os campos para o entity manager

    private EntityManager entityManager;

    // injetar o entity manager usando construtor

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implementar o metodo save

    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);

    }
}




