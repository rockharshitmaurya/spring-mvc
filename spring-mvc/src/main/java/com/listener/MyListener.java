package com.listener;


import com.entities.Todo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("MyListener contextInitialized(param1, param2)");
        ArrayList<Todo> list=new ArrayList<>();
        ServletContext sc=servletContextEvent.getServletContext();
        sc.setAttribute("list",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
