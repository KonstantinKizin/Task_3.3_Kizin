package by.tc.jwd.task3_3.kizin.dao.impl;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.service.impl.EmployeeHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxDaoImpl implements XmlDAO {

   private  SAXParserFactory factory = SAXParserFactory.newInstance();
   private EmployeeHandler handler = new EmployeeHandler();


    public List<Employee> getEmployeeList() throws DAOException {

        SAXParser saxParser = null;

        try {

            saxParser = factory.newSAXParser();

            saxParser.parse(new InputSource(getPath("task.xml")),handler);

            return handler.getEmployeeList();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException(e);
        }


    }
}
