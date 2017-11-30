package by.tc.jwd.task3_3.kizin.controller.command;

import by.tc.jwd.task3_3.kizin.entity.model.Employee;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import java.util.List;

public interface Command {

    List<Employee> execute() throws ServiceException;


}
