package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    Company softwareMachine;
    Company dataMaesters;
    Company greyMatter;

    Employee johnSmith;
    Employee stephanieClarckson;
    Employee lindaKovalsky;
    Employee paulKovalsky;


    @Before
    public void prepareTestData() {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");
        paulKovalsky = new Employee("Paul", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("SoftData Maesters");
        greyMatter = new Company("Grey Matter");

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
    public void testSaveManyToMany(){
        //Given

        //When
        int softwareMachineId = softwareMachine.getId();
        int dataMaestersId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        }

    @Test
    public void testNamedQueryFindCompany(){
        //Given
        final String initString = "Sof";

        //When
        List<Company> companyList = companyDao.retrieveCompaniesNamesStartingWith(initString);

        //Then
        Assert.assertEquals(2, companyList.size());

        //CleanUp

    }
    @Test
    public void testNamedQueryFindEmployee(){
        //Given
        final String lastName = "Kovalsky";

        //When
        List<Employee> employeeList = employeeDao.findEmployeeByName(lastName);

        //Then
        Assert.assertEquals(2, employeeList.size());

        //CleanUp
    }

    @Test
    public void testNamedQueryFindEmployeeInCompany(){
        //Given
        final String lastName = "Kovalsky";
        final String companyName = "Grey Matter";
        //When
        List<Employee> employeeList = employeeDao.findEmployeeByNameInCompany(lastName, companyName);

        //Then
        Assert.assertEquals(2, employeeList.size());

        //CleanUp

    }
    @Test
    public void testNamedQueryFindEmployeeByNameInCompany(){
        //Given
        final String lastName = "Kovalsky";
        final String companyName = "Grey Matter";
        //When
        List<Employee> employeeList = employeeDao.findEmployeeByNameAndCompany(lastName, companyName);

        //Then
        Assert.assertEquals(2, employeeList.size());

        //CleanUp
    }
    }