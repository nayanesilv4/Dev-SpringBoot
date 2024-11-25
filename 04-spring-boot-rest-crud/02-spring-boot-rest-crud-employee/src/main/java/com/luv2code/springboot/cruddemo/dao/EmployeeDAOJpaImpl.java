package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //Definir o campo para o EntityManager

    private EntityManager entityManager;

    // Injetar construtor

    @Autowired
    public EmployeeDAOJpaImpl (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Criar a query

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //Executar a query

        List<Employee> employees = theQuery.getResultList();

        //retornar os resultados
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return null;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
