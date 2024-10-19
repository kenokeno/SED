/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author MOY
 */

import general.Utilerias;
import java.io.Serializable;
import java.util.List;
import modelo.RolesDAO;
import modelo.RolesDTO;

public class RolesBO implements Serializable {
    
    private modelo.RolesDTO clave_dto;
    private List<RolesDTO> claves;
    private modelo.FiltroDTO filtros;
    private String prueba;
    private String validacion;
    private String claves_Seleccionadas;
    private String mensajeError;
    private String errorClave;

    public RolesBO() {
        filtros = new modelo.FiltroDTO();
        claves = RolesDAO.consultaClaves(claves);
        clave_dto = new modelo.RolesDTO();
        errorClave="Se requiere el campo Clave";
    }
    
    public String nuevo(){
        System.out.println("Nuevo...");
        // LIMPIAMOS LOS DATOS
        mensajeError="";
        return "claves_nuevo";
    }
    
    public String editar(){
        System.out.println("Editando...");
        if(!Utilerias.esValidoEditarCheckBox(claves_Seleccionadas)){
            mensajeError = Utilerias.mensajeErrorEditar();
            return "";
        }
        // LIMPIAMOS LOS DATOS
        mensajeError="";
        claves_Seleccionadas="0";
        return "claves_nuevo";
    }
    
    public String eliminar(){
        System.out.println("Eliminanado...");
        if(!Utilerias.esValidoEliminarCheckBox(claves_Seleccionadas)){
            mensajeError = Utilerias.mensajeErrorEliminar();
            return "claves";
        }
        RolesDAO.eliminarClaves(claves_Seleccionadas);
        consultar();
        // LIMPIAMOS LOS DATOS
        mensajeError="";
        claves_Seleccionadas="0";
        return "claves";
    }
    
    public void consultar(){
        setClaves(RolesDAO.filtrarClaves(getFiltros()));
    }
    
    public String cancelar(){
        return "claves";
    }
    
    public String guardar(){
        RolesDAO.nuevaClave(clave_dto);
        // LIMPIAMOS LOS DATOS
        clave_dto = new modelo.RolesDTO(); 
        consultar();
        return "claves";
    }

    /**
     * @return the claves
     */
    public List<RolesDTO> getClaves() {
        return claves;
    }

    /**
     * @param claves the claves to set
     */
    public void setClaves(List<RolesDTO> claves) {
        this.claves = claves;
    }

    /**
     * @return the filtros
     */
    public modelo.FiltroDTO getFiltros() {
        return filtros;
    }

    /**
     * @param filtros the filtros to set
     */
    public void setFiltros(modelo.FiltroDTO filtros) {
        this.filtros = filtros;
    }

    /**
     * @return the prueba
     */
    public String getPrueba() {
        return prueba;
    }

    /**
     * @param prueba the prueba to set
     */
    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    /**
     * @return the validacion
     */
    public String getValidacion() {
        return validacion;
    }

    /**
     * @param validacion the validacion to set
     */
    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    /**
     * @return the claves_Seleccionadas
     */
    public String getClaves_Seleccionadas() {
        return claves_Seleccionadas;
    }

    /**
     * @param claves_Seleccionadas the claves_Seleccionadas to set
     */
    public void setClaves_Seleccionadas(String claves_Seleccionadas) {
        this.claves_Seleccionadas = claves_Seleccionadas;
    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    /**
     * @return the clave_dto
     */
    public modelo.RolesDTO getClave_dto() {
        return clave_dto;
    }

    /**
     * @param clave_dto the clave_dto to set
     */
    public void setClave_dto(modelo.RolesDTO clave_dto) {
        this.clave_dto = clave_dto;
    }

    /**
     * @return the errorClave
     */
    public String getErrorClave() {
        return errorClave;
    }

    /**
     * @param errorClave the errorClave to set
     */
    public void setErrorClave(String errorClave) {
        this.errorClave = errorClave;
    }
}
