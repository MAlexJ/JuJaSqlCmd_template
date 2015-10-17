package ua.com.juja.sqlcmd.controller.controller.impl;

import ua.com.juja.sqlcmd.controller.command.Command;
import ua.com.juja.sqlcmd.controller.controller.AbstractController;
import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;
import ua.com.juja.sqlcmd.exception.imp.ExitException;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;


public class MainController extends AbstractController {
    private String request;
    private Command[] commandCollection;
    private boolean flagExit = true;

    public MainController(View view, DatabaseManager manager, Command[] commands) {
        this.view = view;
        this.manager = manager;
        this.commandCollection = commands;
    }

    @Override
    public void run() {
        init();
        while (flagExit) {
            try {
                boolean flag = true;
                request = view.read();
                if (!request.isEmpty()) {
                    for (Command iter : commandCollection) {
                        if (iter.canProcess(request)) {
                            LOG.debug(iter.getClass());
                            iter.process(request);
                            flag = false;
                        }
                    }
                    if (flag) unsupported(request);
                }
                readLine();
            } catch (ExitException e) {
                //TODO: close connection
                flagExit = false;
            } catch (JuJaSqlCmdException e) {
                LOG.error(e.getMessage());
            }
        }
    }
}
