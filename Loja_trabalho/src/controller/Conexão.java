
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Conexão {
       public Connection con;
    String user = "oracle";
    String password = "oracle";
    String url = "jdbc:oracle:thin:@localhost";

    public void conecta() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver OK");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao");

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());
        }
    }
    
    
    public void fechar(){
        try {
            con.close();
            System.out.println("ok");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }
}
