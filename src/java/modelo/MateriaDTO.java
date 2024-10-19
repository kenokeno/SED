/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moises
 */
public class MateriaDTO {
   private int Id_materia ;
   private String Nombre_materia;
   private String Id_carrera;
   private String unidades;

    /**
     * @return the Id_materia
     */
    public int getId_materia() {
        return Id_materia;
    }

    /**
     * @param Id_materia the Id_materia to set
     */
    public void setId_materia(int Id_materia) {
        this.Id_materia = Id_materia;
    }

    /**
     * @return the Nombre_materia
     */
    public String getNombre_materia() {
        return Nombre_materia;
    }

    /**
     * @param Nombre_materia the Nombre_materia to set
     */
    public void setNombre_materia(String Nombre_materia) {
        this.Nombre_materia = Nombre_materia;
    }

    /**
     * @return the Id_carrera
     */
    public String getId_carrera() {
        return Id_carrera;
    }

    /**
     * @param Id_carrera the Id_carrera to set
     */
    public void setId_carrera(String Id_carrera) {
        this.Id_carrera = Id_carrera;
    }

    /**
     * @return the unidades
     */
    public String getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
   
}
