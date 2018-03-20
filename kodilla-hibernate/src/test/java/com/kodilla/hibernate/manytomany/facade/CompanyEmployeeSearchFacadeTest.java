package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeSearchFacadeTest {
    @Autowired
    CompanyEmployeeSearchFacade searchFacade;

    CompanyDao companyDao;

    Company softwareMachine;
    Company dataMaesters;
    Company greyMatter;

    Employee johnSmith;
    Employee stephanieClarckson;
    Employee lindaKovalsky;
    Employee paulKovalsky;

    @Before
    public void prepareTestData() {
        companyDao = searchFacade.getCompanyDao();

        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");
        paulKovalsky = new Employee("Paul", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("SoftData Maesters");
        greyMatter = new Company("Grey Matters");

        softwareMachine.addEmployee(johnSmith);
        dataMaesters.addEmployee(stephanieClarckson);
        dataMaesters.addEmployee(lindaKovalsky);
        greyMatter.addEmployee(lindaKovalsky);
        greyMatter.addEmployee(johnSmith);
        greyMatter.addEmployee(paulKovalsky);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    @After
    public void clearTestData() {
        int softwareMachineId = softwareMachine.getId();
        int dataMaestersId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();

        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueryFindEmployeeByNamePart() {
        //Given
        final String namePart = "sky";
        //When
        List<Employee> employeeList = searchFacade.getEmployeeByNamePart(namePart);
        //Then
        Assert.assertEquals(2, employeeList.size());

        //CleanUp
    }

    @Test
    public void testNamedQueryFindCompanyByNamePart() {
        //Given
        final String namePart = "ers";
        //When
        List<Company> companyList = searchFacade.getCompanyByNamePart(namePart);
        //Then
        Assert.assertEquals(2, companyList.size());

        //CleanUp
    }

}
