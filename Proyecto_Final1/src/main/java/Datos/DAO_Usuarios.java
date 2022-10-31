package Datos;

import Dominio.DTO_Usuarios;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public interface DAO_Usuarios {
    
    public List<DTO_Usuarios> select() throws SQLException;
    
    public int insert(DTO_Usuarios usuario) throws SQLException;
    
    public int update(DTO_Usuarios usuario) throws SQLException;
    
    public int delete(DTO_Usuarios usuario) throws SQLException;
    
}
