package by.tc.jwd.task3_3.kizin.entity;

import by.tc.jwd.task3_3.kizin.service.ParserService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import by.tc.jwd.task3_3.kizin.service.factory.ServiceFactory;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import static by.tc.jwd.task3_3.kizin.service.impl.PropertyManager.getProperty;

public class test {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ServiceException {


        ServiceFactory factory = ServiceFactory.getInstance();
        ParserService service = factory.getDomParserService();


        for(Employee employee : service.buildEmployeeList()){
            System.out.println(employee);
        }




    }
}
