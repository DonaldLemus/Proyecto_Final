package Datos;

import Dominio.DTO_Alumnos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DAO_Alumnos {
    
    public List<DTO_Alumnos> select() throws SQLException;
    
    public int insert(DTO_Alumnos alumno) throws SQLException;
    
    public int update(DTO_Alumnos alumno) throws SQLException;
    
    public int delete(DTO_Alumnos alumno) throws SQLException;
    
}
