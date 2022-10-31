package Datos;

import Dominio.DTO_Cursos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DAO_Cursos {
    
    public List<DTO_Cursos> select() throws SQLException;
    
    public int insert(DTO_Cursos curso) throws SQLException;
    
    public int update(DTO_Cursos curso) throws SQLException;
    
    public int delete (DTO_Cursos curso) throws SQLException;
    
}
