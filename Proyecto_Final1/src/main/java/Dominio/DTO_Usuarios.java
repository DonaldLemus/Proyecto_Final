package Dominio;

/**
 *
 * @author ASUS
 */
public class DTO_Usuarios {
    
    private int id_alumno;
    private String nombre_alumno;
    private String contrasena_alumno;

    public DTO_Usuarios() {
    }

    public DTO_Usuarios(int id_alumno, String nombre_alumno) {
        this.id_alumno = id_alumno;
        this.nombre_alumno = nombre_alumno;
    }

    public DTO_Usuarios(int id_alumno, String nombre_alumno, String contrasena_alumno) {
        this.id_alumno = id_alumno;
        this.nombre_alumno = nombre_alumno;
        this.contrasena_alumno = contrasena_alumno;
    }  
    
    /**
     * @return the id_alumno
     */
    public int getId_alumno() {
        return id_alumno;
    }

    /**
     * @param id_alumno the id_alumno to set
     */
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    /**
     * @return the nombre_alumno
     */
    public String getNombre_alumno() {
        return nombre_alumno;
    }

    /**
     * @param nombre_alumno the nombre_alumno to set
     */
    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    /**
     * @return the contrasena_alumno
     */
    public String getContrasena_alumno() {
        return contrasena_alumno;
    }

    /**
     * @param contrasena_alumno the contraseña_alumno to set
     */
    public void setContrasena_alumno(String contrasena_alumno) {
        this.contrasena_alumno = contrasena_alumno;
    }
    
    @Override
    public String toString() {
        return "DTO_Usuarios{" + "id_alumno=" + id_alumno + ", nombre_alumno=" + nombre_alumno + ", contrasena_alumno=" + contrasena_alumno + '}';
    }
    
}
