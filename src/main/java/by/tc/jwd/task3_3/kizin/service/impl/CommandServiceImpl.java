package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.service.CommandService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.Map;

public class CommandServiceImpl implements CommandService {
    private CommandMapCreator mapCreator = new CommandMapCreator();

    @Override
    public Map<String, Command> getCommandMap() throws ServiceException {
        return mapCreator.buildCommandMap();
    }
}
