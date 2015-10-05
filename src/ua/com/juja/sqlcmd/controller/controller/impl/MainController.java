package ua.com.juja.sqlcmd.controller.controller.impl;

import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.controller.controller.AbstractController;
import ua.com.juja.sqlcmd.controller.controller.Controller;
import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;
import ua.com.juja.sqlcmd.exception.imp.ExitException;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

import java.util.Collection;
import java.util.HashSet;

public class MainController extends AbstractController implements Controller {


    private Collection<Command> commandCollection = new HashSet<>();

    public MainController(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;
    }

    @Override
    public void addCommand(Command command) {
        this.commandCollection.add(command);
    }

    @Override
    public void run() {
        try {
            greeting();
            while (true) {
                reqest = view.read();
                if (reqest != null && !reqest.isEmpty()) {
                    for (Command iter : commandCollection) {
                        if (iter.canProcess(reqest)) {
                            LOG.debug(iter.getClass());
                            iter.process(reqest);
                        }

                    }
                }
                commandLine();
            }

        } catch (ExitException e) {
            //TODO: close connection
            System.exit(10);
        } catch (JuJaSqlCmdException e) {
            LOG.error(e.getMessage());
        }
    }
}
