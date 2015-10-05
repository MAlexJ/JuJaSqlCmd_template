package ua.com.juja.sqlcmd.controller.controller;


import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

public abstract class AbstractController {
    public static final Logger LOG = Logger.getLogger(AbstractController.class);
    protected View view;
    protected String reqest;
    protected DatabaseManager manager;

    public abstract void run();

    protected void greeting() {
        StringBuilder sb = new StringBuilder();
        sb.append("*******************************************" + "\n");
        sb.append("***          Console Application        ***" + "\n");
        sb.append("*******************************************" + "\n");
        sb.append("Commando \"help\" - FAQ" + "\n");
        sb.append("Commando \"exit\" - exit from the program" + "\n");
        sb.append("\n");
        sb.append("Enter commando and then press enter.........." + "\n");
        view.write(sb.toString());
    }

    protected void commandLine() {
        view.write("Enter commando and then press enter..........");
    }

}
