package by.tc.jwd.task3_3.kizin.service.impl;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.dao.CommandDAO;
import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.dao.factory.DAOFactory;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandMapCreator {

    private DAOFactory factory = DAOFactory.getInstance();
    private CommandDAO commandDAO = factory.getCommandDAO();

    private Command buildCommand(String commandClassName) throws ServiceException {

        try {
            Class clazz = Class.forName(commandClassName);
            Command command =  (Command) clazz.newInstance();
            return command;

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServiceException(e);
        }
    }


    public Map<String , Command> buildCommandMap() throws ServiceException {

        Map<String , Command> commandMap = new HashMap<>();
        try {
            Document xmlDocument = commandDAO.getDocument();
            Map<String , String> map = commandDAO.getCommandMap(xmlDocument.getChildNodes());
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                String commandClassName = map.get(key);
                Command command = this.buildCommand(commandClassName);
                commandMap.put(key, command);
            }
            return commandMap;
        }catch (ServiceException e){
            throw e;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }



}
