package by.tc.jwd.task3_3.kizin.dao.impl;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.service.entityBuilder.EmployeeStaxBuilder;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class StaxDaoImpl implements XmlDAO {

    private XMLInputFactory factory = XMLInputFactory.newInstance();

    public List<Employee> getEmployeeList() throws DAOException {

        try {
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(getPath("task.xml")));

            List<Employee> employees =
                    new  EmployeeStaxBuilder(eventReader).buildEmployeeList();

            return employees;
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new DAOException(e);
        }


    }
}
