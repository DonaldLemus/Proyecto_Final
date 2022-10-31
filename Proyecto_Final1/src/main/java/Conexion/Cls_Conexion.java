package Conexion;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Cls_Conexion {
    //variables de conexion
    private static final String JDBC_URL = "jdbc:sqlite:C:\\sqlite\\SQLiteStudio\\Proyecto_Final";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
     public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
