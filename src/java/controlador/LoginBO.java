/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.UsuarioDTO;
/**
 *
 * @author MOY
 */
public class LoginBO {
    private String nombreUsuario;
    private String password;
    private String tipo;
       
    public LoginBO(){     
    }
     
    public String validar(){
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setClave(nombreUsuario);
        usuario.setPassword(password);
        modelo.UsuariosDAO.validar(usuario);
        tipo = usuario.getClave();
        if(usuario.getId()==0){
            return "invalido";      
        }else{
            general.SessionVariables.setUsuarioLogin(usuario.getNombre() + " " + usuario.getAPaterno()+" " + usuario.getAMaterno());
            general.SessionVariables.setUsuarioLoginDatos(usuario);
            return tipo;
        }
    }


    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
