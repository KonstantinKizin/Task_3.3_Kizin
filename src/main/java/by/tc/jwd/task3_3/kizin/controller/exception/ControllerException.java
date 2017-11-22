package by.tc.jwd.task3_3.kizin.controller.exception;

public class ControllerException extends Exception {

    public ControllerException(){
        super();
    }

    public ControllerException(String message , Throwable cause){
        super(message,cause);
    }

    public ControllerException(String message){
        super(message);
    }

    public ControllerException(Throwable cause){
        super(cause);
    }
}
