package by.tc.jwd.task3_3.kizin.controller.command;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.List;

public class PaginationCommand implements Command {
    @Override
    public List<Employee> execute() throws ServiceException {
        return null;
    }
}
