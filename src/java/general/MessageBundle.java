/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

/**
 *
 * @author alfredo
 */
public class MessageBundle {
    public final String campo_requerido_clave = "'Clave:' es un campo requerido";
    private String campo_requerido_rol = "'Rol:' es un campo requerido";

    /**
     * @return the campo_requerido_clave
     */
    public String getCampo_requerido_clave() {
        return campo_requerido_clave;
    }

    /**
     * @return the campo_requerido_rol
     */
    public String getCampo_requerido_rol() {
        return campo_requerido_rol;
    }

    /**
     * @param campo_requerido_rol the campo_requerido_rol to set
     */
    public void setCampo_requerido_rol(String campo_requerido_rol) {
        this.campo_requerido_rol = campo_requerido_rol;
    }
}
