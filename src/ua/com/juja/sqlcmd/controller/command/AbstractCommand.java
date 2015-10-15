package ua.com.juja.sqlcmd.controller.command;

import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.view.View;

/**
 * Created by ION on 05.10.2015.
 */
public abstract class AbstractCommand {
    public static final Logger LOG = Logger.getLogger(AbstractCommand.class);

    protected View view;




    // sucsess ->  "Успех!\r\n"

    // replayInput ->  "Повтори попытку.\r\n"


    //  errorInput -. "Неудача! по причине: Должно быть четное количество параметров в формате 'create|tableName|column1|value1|column2|value2|...|columnN|valueN', а ты прислал: 'create|user|error'\r\n"


}
