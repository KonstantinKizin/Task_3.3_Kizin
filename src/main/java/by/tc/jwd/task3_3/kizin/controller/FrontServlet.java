package by.tc.jwd.task3_3.kizin.controller;

import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.controller.command.CommandProvider;
import by.tc.jwd.task3_3.kizin.controller.exception.ControllerException;
import by.tc.jwd.task3_3.kizin.entity.Employee;
import by.tc.jwd.task3_3.kizin.service.CommandService;
import by.tc.jwd.task3_3.kizin.service.exception.ServiceException;
import by.tc.jwd.task3_3.kizin.service.factory.ServiceFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrontServlet extends HttpServlet {
    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final CommandService commandService = factory.getCommandService();
    private CommandProvider producer = new CommandProvider();
    private final String HIDDEN_PARAMETER = "command";
    private final String EMPLOYEES_PAGE = "/WEB-INF/jsp/employees.jsp";
    private final String ERROR_PAGE = "/error.jsp";
    private final String ATTR_NAME = "employeeList";
    private List<Employee> employeeList = new ArrayList<>();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String commandName = request.getParameter(HIDDEN_PARAMETER);
            Command command = producer.getCommandMap().get(commandName);
            employeeList.addAll(command.execute());
            request.setAttribute(ATTR_NAME,employeeList);
            employeeList.clear();
            RequestDispatcher rd = request.getRequestDispatcher(EMPLOYEES_PAGE);
            rd.forward(request,response);
        } catch (ServiceException e) {
            response.sendRedirect(ERROR_PAGE);
        }
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
