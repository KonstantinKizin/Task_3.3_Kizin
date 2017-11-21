package by.tc.jwd.task3_3.kizin.controller.command;

import by.tc.jwd.task3_3.kizin.entity.Employee;
import java.util.List;

public interface Command {

    List<Employee> execute();


}
