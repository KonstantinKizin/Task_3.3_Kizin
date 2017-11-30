package by.tc.jwd.task3_3.kizin.service;

import by.tc.jwd.task3_3.kizin.entity.model.Employee;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.List;

public interface ParserService {

    List<Employee> buildEmployeeList() throws ServiceException;
}
