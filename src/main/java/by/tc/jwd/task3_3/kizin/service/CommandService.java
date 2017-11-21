package by.tc.jwd.task3_3.kizin.service;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;

import java.util.Map;

public interface CommandService {

    Map<String ,Command> getCommandMap() throws ServiceException;


}
