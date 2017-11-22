package by.tc.jwd.task3_3.kizin.controller.command;

import by.tc.jwd.task3_3.kizin.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandProvider implements Command {

   private Map<String,Command> commandMap = new HashMap<>();

   public CommandProvider(){

   }



    public Map<String, Command> getCommandMap() {
        return commandMap;
    }


    @Override
    public List<Employee> execute(HttpServletRequest request) {

       Command command = commandMap.get(request.getParameter("HIDDEN_PARAMETER"));
        return command.execute(request);
    }
}
