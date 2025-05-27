package com.example.springbootdatajpa.repository;


import java.util.Date;

import com.example.springbootdatajpa.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public Long getMaxEmpId() {
        try {
            String sql = "SELECT coalesce(max(e.id), 0) FROM Employee e";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
    }

    @Override
    public long updateEmployee(Long empId, String fullName, Date hireDate) {
        Employee e = entityManager.find(Employee.class, empId);
        if (e == null) {
            return 0;
        }
        e.setFullName(fullName);
        e.setHireDate(hireDate);
        entityManager.flush();
        return 1;
    }

}