/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfredo
 */
public class SeccionesDTO {
    private int id;
    private int numero;
    private List<ReactivosDTO> reactivos; 
    private int id_tipo;

    public SeccionesDTO(){
        reactivos = new ArrayList<ReactivosDTO>();
    }
    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the reactivos
     */
    public List<ReactivosDTO> getReactivos() {
        return reactivos;
    }

    /**
     * @param reactivos the reactivos to set
     */
    public void setReactivos(List<ReactivosDTO> reactivos) {
        this.reactivos = reactivos;
    }

    /**
     * @return the id_tipo
     */
    public int getId_tipo() {
        return id_tipo;
    }

    /**
     * @param id_tipo the id_tipo to set
     */
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

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
}
