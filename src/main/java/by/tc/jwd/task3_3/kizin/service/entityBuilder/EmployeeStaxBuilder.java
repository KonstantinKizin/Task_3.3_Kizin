package by.tc.jwd.task3_3.kizin.service.entityBuilder;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyLoaderImpl.getConstant;
import static by.tc.jwd.task3_3.kizin.service.impl.ParserConstants.Tag;

public class EmployeeStaxBuilder {

    private XMLEventReader eventReader;
    private List<Employee> employeeList= new ArrayList<>();
    private Employee employee;
    private Project project;
    private String currentStartElement;

    public EmployeeStaxBuilder(XMLEventReader eventReader){
        this.eventReader = eventReader;
    }


    public List<Employee> buildEmployeeList() throws XMLStreamException {


        while (eventReader.hasNext()){
            XMLEvent event  = eventReader.nextEvent();

            switch (event.getEventType()){

                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = event.asStartElement();
                    currentStartElement = startElement.getName().getLocalPart();

                    if(currentStartElement.equalsIgnoreCase(getConstant(Tag.EMPLOYEE_TAG.name()))){
                        employee = new Employee();
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.PROJECT_NAME_TAG.name()))){
                        project = new Project();
                    }

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();
                    String currentValue = characters.getData();
                    if(currentStartElement.equalsIgnoreCase(getConstant(Tag.FIRST_NAME_TAG.name()))){
                        employee.setFirstName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.LAST_NAME_TAG.name()))){
                        employee.setSecondName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.HIRE_DATE_TAG.name()))){
                        employee.setHireDate(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.PRODUCT_NAME_TAG.name()))){
                        project.setProductName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.ID_NAME_TAG.name()))){
                        project.setId(Integer.parseInt(currentValue));
                    }else if(currentStartElement.equalsIgnoreCase(getConstant(Tag.PRICE_NAME_TAG.name()))){
                        project.setPrice(currentValue);
                    }


                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();
                    if(endElement.getName().getLocalPart().equalsIgnoreCase(getConstant(Tag.PROJECT_NAME_TAG.name()))){
                        employee.getProjects().add(project);
                        project = null;
                    }else if(endElement.getName().getLocalPart().equalsIgnoreCase(getConstant(Tag.EMPLOYEE_TAG.name()))){
                        employeeList.add(employee);
                        employee = null;
                    }
            }
        }
        return employeeList;
    }







}
