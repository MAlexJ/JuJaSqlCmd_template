package ua.com.juja.sqlcmd.controller.controller;


import org.apache.log4j.Logger;
import ua.com.juja.sqlcmd.view.View;

public abstract class AbstractController {
    public static final Logger LOG = Logger.getLogger(AbstractController.class);
    public View view;


    protected void init() {
        view.write("Привет юзер!");
        view.write("Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password");
    }

    protected void readLine() {
        view.write("Введи команду (или help для помощи):");
    }

    protected void unsupported(String str) {
        view.write("Несуществующая команда: " + str);
    }

    protected void connectionCheck(String str) {
        if (!str.equals("help")) {
            if (str.startsWith("connect|") || str.startsWith("create|")|| str.startsWith("clear|")) {
                return;
            }
            view.write("Вы не можете пользоваться командой \'" + str + "\' пока не подключитесь с помощью комманды connect|databaseName|userName|password");
        }
    }


}
