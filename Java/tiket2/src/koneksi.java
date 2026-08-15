import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fahrul
 */
public class koneksi {
    private static Connection conn;

    /**
     *
     * @return
     */
    public static Connection getkoneksi(){
        String host ="jbdc:mysql://localhost/tes",
                user="root",
                pass="";
        try{
            conn=(Connection)DriverManager.getConnection(user, user, pass);
        }catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());
        }return conn;
    }
    static Object getConnection(){
        throw new UnsupportedOperationException("Not Supported yet");
    }
}
