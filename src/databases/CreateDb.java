/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dtvta
 */
public class CreateDb {
    private Connection connect ;
    private Statement statement;
    
    private static final String localhost="127.0.0.1";
    private static final String database="dbcuahangdientu";
    private static final String user="root";
    private static final String password="";
    private static final String characterEncoding="utf8";
    
    private static final String connection="jdbc:mysql://"+localhost+"/"+database+"?useUnicode=true&characterEncoding=utf-8";

    public CreateDb() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager
                    .getConnection(connection,user,password);
           
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            statement.executeUpdate("SET CHARACTER SET UTF8");
            System.out.println(statement.getConnection());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CreateDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }
      
}
