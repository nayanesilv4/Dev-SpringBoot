package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Criar query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);


        // Retornar os valores da query
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Criar Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);

        // Definir os parametros

        theQuery.setParameter("theData", theLastName);

        //Retornar os resultados
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // encontrar estudante por Id

        Student theStudent = entityManager.find(Student.class, id);

        // Deletar do banco de dados
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}




