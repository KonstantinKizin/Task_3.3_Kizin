package by.tc.jwd.task3_3.kizin.dao;

import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import by.tc.jwd.task3_3.kizin.entity.Employee;

import java.util.List;

public interface XmlDAO {

    List<Employee> getEmployeeList() throws DAOException;

   default String getPath(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        String path = new String(classLoader.getResource(fileName).getPath());
        return path;
    }

}
