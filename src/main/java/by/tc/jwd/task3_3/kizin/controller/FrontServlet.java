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
    private final String LIST_ATTR_NAME = "employeeList";
    private final String ERROR_PAGE = "/error.jsp";
    private static int noOfRecords;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String commandName = request.getParameter(HIDDEN_PARAMETER);
            Command command = producer.getCommandMap().get(commandName);
            List<Employee> employeeList = command.execute();
            int page = 1;
            int recordsPerPage = 3;
            noOfRecords = employeeList.size() - 3;
            if(request.getParameter("page") != null){
                page = Integer.parseInt(request.getParameter("page"));
            }
            List<Employee> responseList = getPartOfEmployee(employeeList,(page-1)*recordsPerPage,recordsPerPage);
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute(LIST_ATTR_NAME,responseList);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(EMPLOYEES_PAGE);
            rd.forward(request,response);
            employeeList.clear();
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




    public List<Employee> getPartOfEmployee(List<Employee> list , int start , int count){

        List<Employee> employeePart = new ArrayList<>();

        int index = 0;

        for(int i = start; i < (start + count); i++  ){
            employeePart.add(list.get(i));
            index++;
        }
        noOfRecords = list.size() - index;
        return employeePart;
    }


}
