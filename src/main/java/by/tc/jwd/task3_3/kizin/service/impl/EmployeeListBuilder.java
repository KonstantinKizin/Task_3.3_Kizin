package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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


    public List<Employee> getEmployeeList(){

        NodeList root = this.document.getChildNodes();

        for(int i = 0; i < root.getLength();i++){
            employee = new Employee();
            buildEmployee(root.item(i),employee);
            employeeList.add(employee);
            employee = null;
        }

        return employeeList;
    }


    private void buildEmployee(Node root, Employee employee){
        if(employee == null){
            employee = new Employee();
        }

        NodeList nodeList = root.getChildNodes();

        for(int i = 0; i < nodeList.getLength();i++){

            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element element = (Element) node;

                if(element.getTagName().equalsIgnoreCase(FIRST_NAME_TAG)){
                    this.employee.setFirstName(element.getTextContent());
                }else if(element.getTagName().equalsIgnoreCase(LAST_NAME_TAG)){
                    this.employee.setSecondName(element.getTextContent());
                }else if(element.getTagName().equalsIgnoreCase(PROJECT_NAME_TAG)){
                    Project project = new Project();
                    this.buildProject(nodeList.item(i),project );
                    employee.getProjects().add(project);
                    project = null;
                }
            }
            buildEmployee(nodeList.item(i),employee);
        }
    }

    private void buildProject(Node root , Project project) {

        NodeList nodeList = root.getChildNodes();
        for(int i = 0; i < nodeList.getLength();i++){

            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodeList.item(i);
                if(element.getTagName().equalsIgnoreCase(PRODUCT_NAME_TAG)){
                    project.setProductName(element.getTextContent());
                }else if(element.getTagName().equalsIgnoreCase(ID_NAME_TAG)){
                    project.setId(Integer.parseInt(element.getTextContent()));
                }else if(element.getTagName().equalsIgnoreCase(PRICE_NAME_TAG)){
                    project.setPrice(element.getTextContent());
                }
            }

            buildProject(nodeList.item(i),project);

        }

    }


}
