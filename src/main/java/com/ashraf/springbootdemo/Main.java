package com.ashraf.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Main {

    static String message = "Hey Shoikat!!It's your first maven application.";
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


     static String getMessage() {
        return message;
    }

    static void postgreConnectionCode(){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5491/AshrafPostgreTestDB","postgres","123456");

            System.out.println("connection Successfull");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
         }
         catch(Exception e){ System.out.println(e);}
    }

}
