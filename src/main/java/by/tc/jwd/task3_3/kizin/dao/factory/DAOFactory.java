package by.tc.jwd.task3_3.kizin.dao.factory;

import by.tc.jwd.task3_3.kizin.dao.XmlDAO;
import by.tc.jwd.task3_3.kizin.dao.impl.DomDaoImpl;
import by.tc.jwd.task3_3.kizin.dao.impl.SaxDaoImpl;
import by.tc.jwd.task3_3.kizin.dao.impl.StaxDaoImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private XmlDAO saxDao = new SaxDaoImpl();
    private XmlDAO domDao = new DomDaoImpl();
    private XmlDAO staxDao = new StaxDaoImpl();

    public XmlDAO getSaxDao() {
        return saxDao;
    }

    public XmlDAO getDomDao() {
        return domDao;
    }

    public XmlDAO getStaxDao() {
        return staxDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
