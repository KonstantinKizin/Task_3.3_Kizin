package by.tc.jwd.task3_3.kizin.dao;

import by.tc.jwd.task3_3.kizin.dao.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Map;

public interface CommandDAO {
    Document getDocument() throws DAOException;
    Map<String , String> getCommandMap(NodeList nodeList);
}
