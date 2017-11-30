package by.tc.jwd.task3_3.kizin.controller;
import by.tc.jwd.task3_3.kizin.controller.command.Command;
import by.tc.jwd.task3_3.kizin.controller.command.CommandProvider;
import by.tc.jwd.task3_3.kizin.controller.exception.ControllerInitializationException;
import by.tc.jwd.task3_3.kizin.entity.model.Employee;
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
    private final int RECORDS_PER_PAGE = 3;
    private final int PAGE_DIF = 1;
    private final double DOUBLE_ONE = 1.0;
    private final String NO_OF_PAGE_ATTR_NAME = "noOfPages";
    private final String PAGE_PARAMETER_NAME = "page";
    private final String CURRENT_PAGE_ATTR_NAME = "currentPage";
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
            noOfRecords = employeeList.size() - RECORDS_PER_PAGE;
            if(request.getParameter(PAGE_PARAMETER_NAME) != null){
                page = Integer.parseInt(request.getParameter(PAGE_PARAMETER_NAME));
            }
            List<Employee> responseList = getPartOfEmployee(employeeList,(page-PAGE_DIF)*RECORDS_PER_PAGE,RECORDS_PER_PAGE);
            int noOfPages = (int) Math.ceil(noOfRecords * DOUBLE_ONE / RECORDS_PER_PAGE);
            request.setAttribute(LIST_ATTR_NAME,responseList);
            request.setAttribute(NO_OF_PAGE_ATTR_NAME, noOfPages);
            request.setAttribute(CURRENT_PAGE_ATTR_NAME, page);
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
            throw new ControllerInitializationException("Exception in Servlet init method",e);
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
