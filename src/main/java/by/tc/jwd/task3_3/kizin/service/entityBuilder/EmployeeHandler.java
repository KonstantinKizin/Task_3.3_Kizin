package by.tc.jwd.task3_3.kizin.service.entityBuilder;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyLoaderImpl.getConstant;
import static by.tc.jwd.task3_3.kizin.service.impl.ParserConstants.Tag;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler extends DefaultHandler {

    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();
    private Project project;
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
        if(qName.equalsIgnoreCase(getConstant(Tag.EMPLOYEE_TAG.name()))){
            employee = new Employee();
        }else if(qName.equalsIgnoreCase(getConstant(Tag.PROJECT_NAME_TAG.name()))){
            project = new Project();
        }
    }


    @Override
    public void endElement(String uri,String localName, String qName) throws SAXException{
        if(qName.equalsIgnoreCase(getConstant(Tag.EMPLOYEE_TAG.name()))){
            employeeList.add(employee);
            employee = null;
        }else if(qName.equalsIgnoreCase(getConstant(Tag.PROJECT_NAME_TAG.name()))){
            employee.getProjects().add(project);
            project = null;
        }
    }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException{
        String content = new String(ch,start,length).trim();
        if(!content.isEmpty()){
            if(currentTag.equalsIgnoreCase(getConstant(Tag.LAST_NAME_TAG.name()))){
                employee.setSecondName(content);
            }else if(currentTag.equalsIgnoreCase(getConstant(Tag.FIRST_NAME_TAG.name()))){
                employee.setFirstName(content);
            }else if(currentTag.equalsIgnoreCase(getConstant(Tag.HIRE_DATE_TAG.name()))){
                employee.setHireDate(content);
            }else if(currentTag.equalsIgnoreCase(getConstant(Tag.PRODUCT_NAME_TAG.name()))){
                project.setProductName(content);
            }else if(currentTag.equalsIgnoreCase(getConstant(Tag.ID_NAME_TAG.name()))){
                 project.setId(Integer.parseInt(content));
            }else if(currentTag.equalsIgnoreCase(getConstant(Tag.PRICE_NAME_TAG.name()))){
                project.setPrice(content);
            }
        }
    }
}
