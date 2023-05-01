package bank.management.system;

import java.sql.*;

public class Conn {
//    JDBC connectivity having 5 setps.(Java Database Connectivity).
//    1. Register the Driver.
//    2. Create the Connection.
//    3. Create Statements.
//    4.Execute Query.
//    5. Close Connection.
    
//    JDBC Driver :- 1.JDBC, ODBC bridge driver.
//                   2.Native Driver.
//                   3.Network Protocol driver.
//                   4.Thin Driver.    
    
//    for creating connection declare.
    Connection c;
    
//    for creating statement declare.
    Statement s;
    
    public Conn(){
        try{
//           Registed the Driver
//           Class.forName(com.mysql.cj.jdbc.Driver);
            
//            Create Connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Prashant@123");
            
//            Create Statement
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
