package by.tc.jwd.task3_3.kizin.controller;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.service.CommandService;
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

        Map<String , Command> commandMap = commandService.getCommandMap();



    }







}
