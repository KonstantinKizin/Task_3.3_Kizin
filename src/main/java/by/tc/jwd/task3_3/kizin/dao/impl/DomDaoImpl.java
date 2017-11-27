package by.tc.jwd.task3_3.kizin.dao.impl;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.service.entityBuilder.EmployeeDomBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DomDaoImpl implements XmlDAO {

    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private EmployeeDomBuilder employeeBuilder;

    public List<Employee> getEmployeeList() throws DAOException {

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(getPath("task.xml"));

            employeeBuilder = new EmployeeDomBuilder(document);

            return employeeBuilder.getEmployeeList();

        } catch (ParserConfigurationException | SAXException | IOException e ) {
            throw new DAOException(e);
        }

    }




}
