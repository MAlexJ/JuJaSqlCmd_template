package ua.com.juja.sqlcmd.controller.command;

import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.view.View;

/**
 * Created by ION on 05.10.2015.
 */
public abstract class AbstractCommand {
    public static final Logger LOG = Logger.getLogger(AbstractCommand.class);

    protected  View view;
}
