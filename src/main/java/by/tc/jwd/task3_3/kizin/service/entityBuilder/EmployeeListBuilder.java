package by.tc.jwd.task3_3.kizin.service.entityBuilder;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyLoaderImpl.getConstant;
import static by.tc.jwd.task3_3.kizin.service.impl.ParserConstants.Tag;
public class EmployeeListBuilder {

    private Document document;
    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();
    private Project project;


    public EmployeeListBuilder(Document document){
        this.document = document;
    }
    public List<Employee> getEmployeeList(){

        NodeList node1 = document.getElementsByTagName(getConstant(Tag.EMPLOYEE_TAG.name()));
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
                if(element.getTagName().equalsIgnoreCase(getConstant(Tag.LAST_NAME_TAG.name()))){
                    employee.setSecondName(textContent);
                }else if(element.getTagName().equalsIgnoreCase(getConstant(Tag.FIRST_NAME_TAG.name()))){
                    employee.setFirstName(textContent);
                }else if(element.getTagName().equalsIgnoreCase(getConstant(Tag.HIRE_DATE_TAG.name()))){
                    employee.setHireDate(textContent);
                }else if(element.getTagName().equalsIgnoreCase(getConstant(Tag.PROJECT_NAME_TAG.name()))){
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
                if(element.getTagName().equalsIgnoreCase(getConstant(Tag.PRODUCT_NAME_TAG.name()))){
                    project.setProductName(elementContent);
                }else if(element.getTagName().equalsIgnoreCase(getConstant(Tag.PRICE_NAME_TAG.name()))){
                    project.setPrice(elementContent);
                }else if(element.getTagName().equalsIgnoreCase(getConstant(Tag.ID_NAME_TAG.name()))){
                    project.setId(Integer.parseInt(elementContent));
                }
            }
            buildProject(node);
        }
        return project;
    }






}
