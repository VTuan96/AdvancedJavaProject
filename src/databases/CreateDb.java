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
    
    private static final String localhost="localhost";
    private static final String database="dbcuahangdientu";
    private static final String user="root";
    private static final String password="";

    public CreateDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://"+localhost+"/"+database+"?"
                            + "user="+user+"&password="+password+"");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
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
