package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler extends DefaultHandler {


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
    private String currentTag;



    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException{

        if(currentTag == null){
            currentTag = new String();
        }
        currentTag = qName;
        if(qName.equalsIgnoreCase(EMPLOYEE_TAG)){
            employee = new Employee();
        }else if(qName.equalsIgnoreCase(PROJECT_NAME_TAG)){
            project = new Project();
        }
    }


    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException{

        if(qName.equalsIgnoreCase(EMPLOYEE_TAG)){
            employeeList.add(employee);
            employee = null;
        }else if(qName.equalsIgnoreCase(PROJECT_NAME_TAG)){
            projectList.add(project);
            project = null;
        }else if(qName.equalsIgnoreCase(PROJECTS_NAME_TAG)){
            employee.getProjects().addAll(projectList);
            projectList.clear();
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException{
        String content = new String(ch,start,length).trim();
        if(!content.isEmpty()){
            if(currentTag.equalsIgnoreCase(LAST_NAME_TAG)){
                employee.setSecondName(content);
            }else if(currentTag.equalsIgnoreCase(FIRST_NAME_TAG)){
                employee.setFirstName(content);
            }else if(currentTag.equalsIgnoreCase(HIRE_DATE_TAG)){
                employee.setHireDate(content);
            }else if(currentTag.equalsIgnoreCase(PRODUCT_NAME_TAG)){
                project.setProductName(content);
            }else if(currentTag.equalsIgnoreCase(ID_NAME_TAG)){
                 project.setId(Integer.parseInt(content));
            }else if(currentTag.equalsIgnoreCase(PRICE_NAME_TAG)){
                project.setPrice(content);
            }
        }
    }
}
