package by.tc.jwd.task3_3.kizin.controller.command;

import by.tc.jwd.task3_3.kizin.entity.model.Employee;
import by.tc.jwd.task3_3.kizin.service.ParserService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import by.tc.jwd.task3_3.kizin.service.factory.ServiceFactory;

import java.util.List;

public class StAXParseCommand implements Command {

    private ServiceFactory factory = ServiceFactory.getInstance();
    private ParserService service = factory.getStaxParserService();


    @Override
    public List<Employee> execute() throws ServiceException {
        return service.buildEmployeeList();
    }
}
