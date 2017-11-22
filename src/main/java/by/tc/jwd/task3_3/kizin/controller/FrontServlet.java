package by.tc.jwd.task3_3.kizin.controller;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.controller.command.CommandProvider;
import by.tc.jwd.task3_3.kizin.controller.exception.ControllerException;
import by.tc.jwd.task3_3.kizin.service.CommandService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import by.tc.jwd.task3_3.kizin.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FrontServlet extends HttpServlet {
    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final CommandService commandService = factory.getCommandService();
    private CommandProvider producer = new CommandProvider();



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Map<String , Command> commandMap = commandService.getCommandMap();
            producer.getCommandMap().putAll(commandMap);

        } catch (ServiceException e) {
            throw new RuntimeException(new ControllerException(e));
        }


    }

}
