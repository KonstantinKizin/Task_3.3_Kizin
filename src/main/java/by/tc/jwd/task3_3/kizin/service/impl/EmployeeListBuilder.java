package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyManager.getProperty;
public class EmployeeListBuilder {

    private Document document;
    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();
    private Project project;
    private final String EMPLOYEE_TAG = "employee";
    private final String LAST_NAME_TAG = "lastname";
    private final String FIRST_NAME_TAG = "firstname";
    private final String HIRE_DATE_TAG = "hiredate";
    private final String PROJECT_NAME_TAG = "project";
    private final String PRODUCT_NAME_TAG = "product";
    private final String ID_NAME_TAG = "id";
    private final String PRICE_NAME_TAG = "price";


    public EmployeeListBuilder(Document document){
        this.document = document;
    }
    public List<Employee> getEmployeeList(){

        NodeList node1 = document.getElementsByTagName(EMPLOYEE_TAG);
        for(int i = 0; i < node1.getLength(); i ++ ){
            Node node = node1.item(i);
            employee = new Employee();
            buildEmployee(node);
            employeeList.add(employee);
            employee = null;
        }
        return employeeList;
    }


    private Employee buildEmployee(Node root) {
        NodeList nodeList = root.getChildNodes();

        for(int i = 0; i < nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                String textContent = element.getTextContent();
                if(element.getTagName().equalsIgnoreCase(LAST_NAME_TAG)){
                    employee.setSecondName(textContent);
                }else if(element.getTagName().equalsIgnoreCase(FIRST_NAME_TAG)){
                    employee.setFirstName(textContent);
                }else if(element.getTagName().equalsIgnoreCase(HIRE_DATE_TAG)){
                    employee.setHireDate(textContent);
                }else if(element.getTagName().equalsIgnoreCase(PROJECT_NAME_TAG)){
                    project = new Project();
                    buildProject(node);
                    employee.getProjects().add(project);
                    project = null;
                }
            }

            buildEmployee(node);
        }
        return employee;
    }


    private Project buildProject(Node root ) {

        NodeList nodeList = root.getChildNodes();
        for(int i = 0; i < nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)node;
                String elementContent = element.getTextContent();
                if(element.getTagName().equalsIgnoreCase(PRODUCT_NAME_TAG)){
                    project.setProductName(elementContent);
                }else if(element.getTagName().equalsIgnoreCase(PRICE_NAME_TAG)){
                    project.setPrice(elementContent);
                }else if(element.getTagName().equalsIgnoreCase(ID_NAME_TAG)){
                    project.setId(Integer.parseInt(elementContent));
                }
            }
            buildProject(node);
        }
        return project;
    }






}
