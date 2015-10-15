package ua.com.juja.sqlcmd.controller.controller;


import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.model.DatabaseManager;
import ua.com.juja.sqlcmd.view.View;

public abstract class AbstractController {
    public static final Logger LOG = Logger.getLogger(AbstractController.class);
    protected View view;
    protected DatabaseManager manager;

    public abstract void run();

    protected void init() {
        view.write("Привет юзер!");
        view.write("Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password");
    }

    protected void unsupported(String str){
        view.write("Несуществующая команда: "+str);
    }

}
