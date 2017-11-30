package by.tc.jwd.task3_3.kizin.dao.impl;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.entity.model.Employee;
import by.tc.jwd.task3_3.kizin.service.entityBuilder.EmployeeDomBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DomDaoImpl implements XmlDAO {

    private final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private final String XML_FILE_NAME = "task.xml";

    public List<Employee> getEmployeeList() throws DAOException {

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(getPath(XML_FILE_NAME));

            EmployeeDomBuilder employeeBuilder = new EmployeeDomBuilder(document);

            return employeeBuilder.getEmployeeList();

        } catch (ParserConfigurationException | SAXException | IOException e ) {
            throw new DAOException("Exception from DomDao in getEmployeeList method",e);
        }

    }




}
