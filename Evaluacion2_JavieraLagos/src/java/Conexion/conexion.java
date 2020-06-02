
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class conexion {
    Connection con;
    public conexion(){
        try {
         Class.forName("com.mysql.jdbc.Driver");
         con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/Evaluacion2","root","");
        } catch (Exception e) {
           System.err.print("Error" +e);
           
        }
    }
    public static void main(String[] args) {
        conexion cn=new conexion();
    }
}

