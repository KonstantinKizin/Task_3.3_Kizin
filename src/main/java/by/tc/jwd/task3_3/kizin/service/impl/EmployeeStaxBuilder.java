package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.entity.Project;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.List;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyManager.getProperty;

public class EmployeeStaxBuilder {

    private XMLEventReader eventReader;
    private List<Employee> employeeList;
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

                    if(currentStartElement.equalsIgnoreCase(getProperty("EMPLOYEE_TAG"))){
                        employee = new Employee();
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("PROJECT_NAME_TAG"))){
                        project = new Project();
                    }

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();
                    String currentValue = characters.getData();
                    if(currentStartElement.equalsIgnoreCase(getProperty("FIRST_NAME_TAG"))){
                        employee.setFirstName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("LAST_NAME_TAG"))){
                        employee.setSecondName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("HIRE_DATE_TAG"))){
                        employee.setHireDate(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("PRODUCT_NAME_TAG"))){
                        project.setProductName(currentValue);
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("ID_NAME_TAG"))){
                        project.setId(Integer.parseInt(currentValue));
                    }else if(currentStartElement.equalsIgnoreCase(getProperty("PRICE_NAME_TAG"))){
                        project.setPrice(currentValue);
                    }

                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();
                    if(endElement.getName().getLocalPart().equalsIgnoreCase(getProperty("PROJECT_NAME_TAG"))){
                        employee.getProjects().add(project);
                        project = null;
                    }else if(endElement.getName().getLocalPart().equalsIgnoreCase(getProperty("EMPLOYEE_TAG"))){
                        employeeList.add(employee);
                        employee = null;
                    }
            }

        }


        return employeeList;
    }







}
