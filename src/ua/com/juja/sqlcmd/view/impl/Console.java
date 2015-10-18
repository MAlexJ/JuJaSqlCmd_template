package ua.com.juja.sqlcmd.view.impl;

import ua.com.juja.sqlcmd.view.View;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console implements View {

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        String inputStream = null;
        try {
            inputStream = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (NoSuchElementException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
