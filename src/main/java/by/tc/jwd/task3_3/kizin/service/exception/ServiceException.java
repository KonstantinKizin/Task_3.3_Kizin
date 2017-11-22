package by.tc.jwd.task3_3.kizin.service.exception;

public class ServiceException extends Exception{


    public ServiceException(){
        super();
    }

    public ServiceException(String message , Throwable cause){
        super(message,cause);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }


}
