package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListBuilder {

    private Document document;
    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();
    private Project project;
    private List<Project> projectList = new ArrayList<>();
    private final String EMPLOYEE_TAG = "employee";
    private final String LAST_NAME_TAG = "lastname";
    private final String FIRST_NAME_TAG = "firstname";
    private final String HIRE_DATE_TAG = "hiredate";
    private final String PROJECTS_NAME_TAG = "projects";
    private final String PROJECT_NAME_TAG = "project";
    private final String PRODUCT_NAME_TAG = "product";
    private final String ID_NAME_TAG = "id";
    private final String PRICE_NAME_TAG = "price";
    

    public EmployeeListBuilder(Document document){
        this.document = document;
    }






}
