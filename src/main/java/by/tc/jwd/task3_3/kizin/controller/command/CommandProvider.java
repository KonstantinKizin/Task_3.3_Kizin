package by.tc.jwd.task3_3.kizin.controller.command;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

   private Map<String,Command> commandMap = new HashMap<>();

   public CommandProvider(){

   }



    public Map<String, Command> getCommandMap() {
        return commandMap;
    }



}
