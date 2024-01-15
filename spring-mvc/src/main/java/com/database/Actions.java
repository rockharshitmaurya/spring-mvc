package com.database;

import com.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Component
public class Actions {

    @Autowired
    Connection con;

    public boolean insertData(Todo todo) {
        try {
            PreparedStatement query = con.prepareStatement("insert into Todo values(?,?,?)");
            query.setString(1, todo.getTitle());
            query.setString(2, todo.getContent());
            query.setString(3, todo.getContent());
            int rows = query.executeUpdate();
            if (rows > 0) {
                System.out.println(rows + " Updated");
                return true;
            } else {
                System.out.println("Record not inserted");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Todo> getTodos(){
        ArrayList<Todo> all_data=new ArrayList<>();
        try{
            PreparedStatement pstmt=con.prepareStatement("select * from Todo");
            ResultSet rst=pstmt.executeQuery();
            while (rst!=null && rst.next()){
//                System.out.println("Hi");
                all_data.add(new Todo(rst.getString("title"),rst.getString("content")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return all_data;
    }

}
