package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.dao.factory.DAOFactory;
import by.tc.jwd.task3_3.kizin.entity.model.Employee;
import by.tc.jwd.task3_3.kizin.service.ParserService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.List;

public class DomParserServiceImpl implements ParserService {

    private DAOFactory factory = DAOFactory.getInstance();
    private XmlDAO domDao = factory.getDomDao();


    @Override
    public List<Employee> buildEmployeeList() throws ServiceException {
        try {
            return domDao.getEmployeeList();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
