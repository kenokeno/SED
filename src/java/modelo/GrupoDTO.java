/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moises
 */
public class GrupoDTO {
    private int Id_grupo;
    private String Nombre;
    private String Id_carrera;
   

    /**
     * @return the Id_grupo
     */
    public int getId_grupo() {
        return Id_grupo;
    }

    /**
     * @param Id_grupo the Id_grupo to set
     */
    public void setId_grupo(int Id_grupo) {
        this.Id_grupo = Id_grupo;
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
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the checkBox
     */
   
}
