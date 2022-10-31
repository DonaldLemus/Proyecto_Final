package Datos;

import Conexion.Cls_Conexion;
import Dominio.DTO_Alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAO_AlumnosImpl implements DAO_Alumnos{
    
    private static final String SQL_Select = "Select id_alumno, carne_alumno, nombre_alumno, correo from tb_Alumnos";
    private static final String SQL_Insert = "Insert into tb_Alumnos (carne_alumno, nombre_alumno, correo) values (?,?,?)";
    private static final String SQL_Update = "Update tb_Alumnos set carne_alumno = ?, nombre_alumno = ?, correo = ? where id_alumno = ?";
    private static final String SQL_Delete = "Delete from tb_Alumnos where id_alumno = ?";

    private Connection conexion;
    
    public DAO_AlumnosImpl(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public List<DTO_Alumnos> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DTO_Alumnos alumno = null;
        List<DTO_Alumnos> alumnos = new ArrayList<DTO_Alumnos>();
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Select);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_alumno");
                int carne = rs.getInt("carne_alumno");
                String nombre = rs.getString("nombre_alumno");
                String correo = rs.getString("correo");
                
                alumno = new DTO_Alumnos();
                alumno.setId_alumno(id);
                alumno.setCarne_alumno(carne);
                alumno.setNombre_alumno(nombre);
                alumno.setCorreo(correo);
                alumnos.add(alumno);
            }
            
        }finally{
            Cls_Conexion.close(stmt);
            Cls_Conexion.close(rs);
            if(this.conexion == null){
                Cls_Conexion.close(conn);
            }
        }
        return alumnos;
    }

    @Override
    public int insert(DTO_Alumnos alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Insert);
            stmt.setInt(1, alumno.getCarne_alumno());
            stmt.setString(2, alumno.getNombre_alumno());
            stmt.setString(3, alumno.getCorreo());
            rows = stmt.executeUpdate();          
        }finally{
            Cls_Conexion.close(stmt);
            if(this.conexion == null){
                Cls_Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(DTO_Alumnos alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Update);
            stmt.setInt(1, alumno.getCarne_alumno());
            stmt.setString(2, alumno.getNombre_alumno());
            stmt.setString(3, alumno.getCorreo());
            stmt.setInt(4, alumno.getId_alumno());
            rows = stmt.executeUpdate();
        }finally{
            Cls_Conexion.close(stmt);
            if(this.conexion ==  null){
                Cls_Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(DTO_Alumnos alumno) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Delete);
            stmt.setInt(1, alumno.getId_alumno());
            rows = stmt.executeUpdate();
        }finally{
            Cls_Conexion.close(stmt);
            if(this.conexion == null){
                Cls_Conexion.close(conn);
            }
        }
        return rows;
    }
}
