package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyEmployeeSearchFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> getCompanyByNamePart(String substring) {
        return companyDao.findCompanyByNamePart('%' + substring + '%');
    }

    public List<Employee> getEmployeeByNamePart(String substring) {
        return employeeDao.findEmployeeByNamePart('%' + substring + '%');
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }
}
