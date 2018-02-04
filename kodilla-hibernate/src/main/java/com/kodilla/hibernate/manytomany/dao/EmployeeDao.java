package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> findEmployeeByName(@Param("LASTNAME") String lastName);
    List<Employee> findEmployeeByNameInCompany(@Param("LASTNAME") String lastName, @Param("COMPANY") String company);
    List<Employee> findEmployeeByNameAndCompany(@Param("LASTNAME") String lastName, @Param("COMPANYNAME") String company);
}
