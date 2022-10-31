package Datos;

import Conexion.Cls_Conexion;
import Dominio.DTO_Cursos;
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
public class DAO_CursosImpl implements DAO_Cursos{
    
    private static final String SQL_Select = "Select id_curso, nombre_curso, catedratico, seccion from tb_Curso";
    private static final String SQL_Insert = "Insert into tb_Curso (nombre_curso, catedratico, seccion) values (?,?,?)";
    private static final String SQL_Update = "Update tb_Curso set nombre_curso = ?, catedratico = ?, seccion = ? where id_curso = ?";
    private static final String SQL_Delete = "Delete from tb_Curso where id_curso = ?";

    private Connection conexion;
    
    public DAO_CursosImpl(Connection conexion){
        this.conexion = conexion;
    }
    
    @Override
    public List<DTO_Cursos> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DTO_Cursos curso = null;
        List<DTO_Cursos> cursos = new ArrayList<DTO_Cursos>();
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Select);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_curso");
                String nombre = rs.getString("nombre_curso");
                String catedartico = rs.getString("catedratico");
                String seccion = rs.getString("seccion");
                
                curso = new DTO_Cursos();
                curso.setId_curso(id);
                curso.setNombre_curso(nombre);
                curso.setCatedratico(catedartico);
                curso.setSeccion(seccion);
                cursos.add(curso);
            }
            
        }finally{
            Cls_Conexion.close(rs);
            Cls_Conexion.close(stmt);
            if(this.conexion == null){
                Cls_Conexion.close(conn);
            }        
        }
        return cursos;
    }

    @Override
    public int insert(DTO_Cursos curso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Insert);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getCatedratico());
            stmt.setString(3, curso.getSeccion());
            rows = stmt.executeUpdate();
        }finally{
            Cls_Conexion.close(stmt);
            if(this.conexion == null)
                Cls_Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int update(DTO_Cursos curso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Update);
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getCatedratico());
            stmt.setString(3, curso.getSeccion());
            stmt.setInt(4, curso.getId_curso());
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
    public int delete(DTO_Cursos curso) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = this.conexion != null ? this.conexion : Cls_Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_Delete);
            stmt.setInt(1, curso.getId_curso());
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
