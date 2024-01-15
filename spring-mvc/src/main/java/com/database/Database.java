package com.database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;


//@Configuration
@Component
public class Database {
    static  Connection con;

    @Bean
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String password="Admin@123";
            String url="jdbc:mysql://localhost:3306/TodoMVC?autoReconnect=true&useSSL=false";
//              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_Pratice?user=root&password=Admin@123");
            con=DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
