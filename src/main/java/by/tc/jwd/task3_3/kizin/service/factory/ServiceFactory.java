package by.tc.jwd.task3_3.kizin.service.factory;

import by.tc.jwd.task3_3.kizin.service.CommandService;
import by.tc.jwd.task3_3.kizin.service.impl.CommandServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private CommandService commandService = new  CommandServiceImpl();

    public CommandService getCommandService() {
        return commandService;
    }

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        return instance;
    }
}
