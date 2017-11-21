package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.dao.CommandDAO;
import by.tc.jwd.task3_3.kizin.dao.impl.CommandDAOImpl;
import by.tc.jwd.task3_3.kizin.service.CommandService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.Map;

public class CommandServiceImpl implements CommandService {
    private CommandDAO commandDAO = new CommandDAOImpl();
    @Override
    public Map<String, Command> getCommandMap() throws ServiceException {

    }
}
