/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author moises
 */
public class PeriodoDTO {
    private int Id;
    private String Inicio;
    private String Fin;
    
    /**
     * @return the Inicio
     */
    public String getInicio() {
        return Inicio;
    }

    /**
     * @param Inicio the Inicio to set
     */
    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    /**
     * @return the Fin
     */
    public String getFin() {
        return Fin;
    }

    /**
     * @param Fin the Fin to set
     */
    public void setFin(String Fin) {
        this.Fin = Fin;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    
    
}
