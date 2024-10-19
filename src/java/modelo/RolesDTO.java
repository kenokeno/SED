/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MOY
 */
public class RolesDTO {
    private int id;
    private String clave;
    private String rol;
    private String checkBox;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the checkBox
     */
    public String getCheckBox() {
        return checkBox;
    }

    /**
     * @param checkBox the checkBox to set
     */
    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }
}
