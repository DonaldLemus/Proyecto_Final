package Dominio;

/**
 *
 * @author ASUS
 */
public class DTO_Cursos {
    
    private int id_curso;
    private String nombre_curso;
    private String catedratico;
    private String seccion;

    public DTO_Cursos(int id_curso, String nombre_curso, String catedratico, String seccion) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.catedratico = catedratico;
        this.seccion = seccion;
    }

    public DTO_Cursos(int id_curso, String nombre_curso, String catedratico) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.catedratico = catedratico;
    }

    public DTO_Cursos(int id_curso, String nombre_curso) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
    }

    public DTO_Cursos() {
    }

    public DTO_Cursos(int id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the id_curso
     */
    public int getId_curso() {
        return id_curso;
    }

    /**
     * @param id_curso the id_curso to set
     */
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the nombre_curso
     */
    public String getNombre_curso() {
        return nombre_curso;
    }

    /**
     * @param nombre_curso the nombre_curso to set
     */
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    /**
     * @return the catedratico
     */
    public String getCatedratico() {
        return catedratico;
    }

    /**
     * @param catedratico the catedratico to set
     */
    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "DTO_Cursos{" + "id_curso=" + id_curso + ", nombre_curso=" + nombre_curso + ", catedratico=" + catedratico + ", seccion=" + seccion + '}';
    }
    
    
}
