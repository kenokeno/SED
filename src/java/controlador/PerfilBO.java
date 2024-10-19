/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import modelo.UsuarioDTO;

/**
 *
 *
 * id nombre aPaterno aMaterno clave password mail foto profesion
 *
 * @author MOY
 */
public class PerfilBO implements Serializable {

    private UsuarioDTO usuario;
    private String nombreDisabled;
    private String disabledPaterno;
    private String disabledMaterno;
    private String disabledClave;
    private String disabledNombreUsuario;
    private String password1Disabled;
    private String mailDisabled;
    private String fotoDisabled;
    private String profecionDisabled;
    private String botonGuardarDisabled;
    private String botonCancelarDisabled;
    private String botonModificarDisabled;

    public PerfilBO() {
        usuario = (UsuarioDTO) general.SessionVariables.getUsuarioLoginDatos();
        nombreDisabled = "true";
        disabledPaterno = "true";
        disabledMaterno = "true";
        disabledClave = "true";
        disabledNombreUsuario = "true";
        password1Disabled = "true";
        mailDisabled = "true";
        fotoDisabled = "true";
        profecionDisabled = "true";
        botonCancelarDisabled = "true";
        botonGuardarDisabled = "true";
        botonModificarDisabled = "false";
    }

    // Habilita los campos para poder modificar 
    public void modificar() {
        nombreDisabled = "false";
        disabledPaterno = "false";
        disabledMaterno = "false";
        disabledClave = "true";
        disabledNombreUsuario = "false";
        password1Disabled = "false";
        mailDisabled = "false";
        fotoDisabled = "false";
        profecionDisabled = "false";
        botonCancelarDisabled = "false";
        botonModificarDisabled = "true";
        botonGuardarDisabled = "false";
        System.out.print("Habilitar-Perfil-Modifica");

    }
    // Deshabilita los campos para no poder modificar 

    public void cancelar() {
        disabledNombreUsuario = "true";
        botonCancelarDisabled = "true";
        botonModificarDisabled = "false";
        botonGuardarDisabled = "true";
        System.out.print("Habilitar-Perfil-Cancelar");
    }

    public String modificando() {
        System.out.println("Dato modificado: " + usuario.getNombreUsuario());
        modelo.UsuariosDAO.modificar(getUsuario());
        disabledNombreUsuario = "true";
        botonCancelarDisabled = "true";
        botonModificarDisabled = "false";
        botonGuardarDisabled = "true";
        System.out.print("Modificando-Perfil-Proceso");
        return "";
    }

    /**
     * @return the usuario
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nombreDisabled
     */
    public String getNombreDisabled() {
        return nombreDisabled;
    }

    /**
     * @param nombreDisabled the nombreDisabled to set
     */
    public void setNombreDisabled(String nombreDisabled) {
        this.nombreDisabled = nombreDisabled;
    }

    /**
     * @return the disabledPaterno
     */
    public String getDisabledPaterno() {
        return disabledPaterno;
    }

    /**
     * @param disabledPaterno the disabledPaterno to set
     */
    public void setDisabledPaterno(String disabledPaterno) {
        this.disabledPaterno = disabledPaterno;
    }

    /**
     * @return the disabledMaterno
     */
    public String getDisabledMaterno() {
        return disabledMaterno;
    }

    /**
     * @param disabledMaterno the disabledMaterno to set
     */
    public void setDisabledMaterno(String disabledMaterno) {
        this.disabledMaterno = disabledMaterno;
    }

    /**
     * @return the disabledClave
     */
    public String getDisabledClave() {
        return disabledClave;
    }

    /**
     * @param disabledClave the disabledClave to set
     */
    public void setDisabledClave(String disabledClave) {
        this.disabledClave = disabledClave;
    }

    /**
     * @return the disabledNombreUsuario
     */
    public String getDisabledNombreUsuario() {
        return disabledNombreUsuario;
    }

    /**
     * @param disabledNombreUsuario the disabledNombreUsuario to set
     */
    public void setDisabledNombreUsuario(String disabledNombreUsuario) {
        this.disabledNombreUsuario = disabledNombreUsuario;
    }

    /**
     * @return the password1Disabled
     */
    public String getPassword1Disabled() {
        return password1Disabled;
    }

    /**
     * @param password1Disabled the password1Disabled to set
     */
    public void setPassword1Disabled(String password1Disabled) {
        this.password1Disabled = password1Disabled;
    }

    /**
     * @return the mailDisabled
     */
    public String getMailDisabled() {
        return mailDisabled;
    }

    /**
     * @param mailDisabled the mailDisabled to set
     */
    public void setMailDisabled(String mailDisabled) {
        this.mailDisabled = mailDisabled;
    }

    /**
     * @return the fotoDisabled
     */
    public String getFotoDisabled() {
        return fotoDisabled;
    }

    /**
     * @param fotoDisabled the fotoDisabled to set
     */
    public void setFotoDisabled(String fotoDisabled) {
        this.fotoDisabled = fotoDisabled;
    }

    /**
     * @return the profecionDisabled
     */
    public String getProfecionDisabled() {
        return profecionDisabled;
    }

    /**
     * @param profecionDisabled the profecionDisabled to set
     */
    public void setProfecionDisabled(String profecionDisabled) {
        this.profecionDisabled = profecionDisabled;
    }

    /**
     * @return the botonGuardarDisabled
     */
    public String getBotonGuardarDisabled() {
        return botonGuardarDisabled;
    }

    /**
     * @param botonGuardarDisabled the botonGuardarDisabled to set
     */
    public void setBotonGuardarDisabled(String botonGuardarDisabled) {
        this.botonGuardarDisabled = botonGuardarDisabled;
    }

    /**
     * @return the botonCancelarDisabled
     */
    public String getBotonCancelarDisabled() {
        return botonCancelarDisabled;
    }

    /**
     * @param botonCancelarDisabled the botonCancelarDisabled to set
     */
    public void setBotonCancelarDisabled(String botonCancelarDisabled) {
        this.botonCancelarDisabled = botonCancelarDisabled;
    }

    /**
     * @return the botonModificarDisabled
     */
    public String getBotonModificarDisabled() {
        return botonModificarDisabled;
    }

    /**
     * @param botonModificarDisabled the botonModificarDisabled to set
     */
    public void setBotonModificarDisabled(String botonModificarDisabled) {
        this.botonModificarDisabled = botonModificarDisabled;
    }
}
