package Datos;

import Conexion.Cls_Conexion;
import Dominio.DTO_Usuarios;
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
public class DAO_UsuariosImpl implements DAO_Usuarios{
    
    private static final String SQL_Select = "Select id_alumno, nombre_alumno, contraseña_alumno from tb_login";
    private static final String SQL_Insert = "Insert into tb_login (nombre_alumno, contraseña_alumno) values (?,?)";
    private static final String SQL_Update = "Update tb_login set nombre_alumno = ?, contraseña_alumno = ? where id_alumno = ?";
    private static final String SQL_Delete = "Delete from tb_login where id_alumno = ?";

    private Connection conexion;
    
    public DAO_UsuariosImpl(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public List<DTO_Usuarios> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DTO_Usuarios usuario = null;
        List<DTO_Usuarios> usuarios = new ArrayList<DTO_Usuarios>();
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Select);
            rs = stmt.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre_alumno");
                String contrasena = rs.getString("contraseña_alumno");
                
                usuario = new DTO_Usuarios();
                usuario.setNombre_alumno(nombre);
                usuario.setContrasena_alumno(contrasena);
                usuarios.add(usuario);
            }
            
            
        }finally{
            Cls_Conexion.close(rs);
            Cls_Conexion.close(stmt);
            if(this.conexion == null){
                Cls_Conexion.close(conn);
            }
        }
        return usuarios;
    }

    @Override
    public int insert(DTO_Usuarios usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Insert);
            stmt.setString(1, usuario.getNombre_alumno());
            stmt.setString(2, usuario.getContrasena_alumno());
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
    public int update(DTO_Usuarios usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Update);
            stmt.setString(1, usuario.getNombre_alumno());
            stmt.setString(2, usuario.getContrasena_alumno());
            stmt.setInt(3, usuario.getId_alumno());
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
    public int delete(DTO_Usuarios usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Delete);
            stmt.setInt(1, usuario.getId_alumno());
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
