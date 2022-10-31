package Dominio;

/**
 *
 * @author ASUS
 */
public class DTO_Alumnos {
    private int id_alumno;
    private int carne_alumno;
    private String nombre_alumno;
    private String correo;

    public DTO_Alumnos() {
    }

    public DTO_Alumnos(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public DTO_Alumnos(int id_alumno, int carne_alumno) {
        this.id_alumno = id_alumno;
        this.carne_alumno = carne_alumno;
    }

    public DTO_Alumnos(int id_alumno, int carne_alumno, String nombre_alumno) {
        this.id_alumno = id_alumno;
        this.carne_alumno = carne_alumno;
        this.nombre_alumno = nombre_alumno;
    }

    public DTO_Alumnos(int id_alumno, int carne_alumno, String nombre_alumno, String correo) {
        this.id_alumno = id_alumno;
        this.carne_alumno = carne_alumno;
        this.nombre_alumno = nombre_alumno;
        this.correo = correo;
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
     * @return the carne_alumno
     */
    public int getCarne_alumno() {
        return carne_alumno;
    }

    /**
     * @param carne_alumno the carne_alumno to set
     */
    public void setCarne_alumno(int carne_alumno) {
        this.carne_alumno = carne_alumno;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "DTO_Alumnos{" + "id_alumno=" + id_alumno + ", carne_alumno=" + carne_alumno + ", nombre_alumno=" + nombre_alumno + ", correo=" + correo + '}';
    }
    
    
}
