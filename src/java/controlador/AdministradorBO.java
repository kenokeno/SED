/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;

/**
 *
 * @author moises
 */
public class AdministradorBO implements Serializable {
    private String bean;
    
    public AdministradorBO(){
        bean = "../Administrador/principal.jsp";
    }

    public String manage(String bean){
        if(bean.equalsIgnoreCase("usuarios"))
            this.bean = "Usuarios/usuarios.jsp";
        if(bean.equalsIgnoreCase("carreras"))
            this.bean = "Carreras/carreras.jsp";
        if(bean.equalsIgnoreCase("profesiones"))
            this.bean = "Profesiones/profesiones.jsp";
        if(bean.equalsIgnoreCase("claves"))
            this.bean = "Claves/claves.jsp";
        if(bean.equalsIgnoreCase("perfil"))
            this.bean = "Perfil/perfil.jsp";
        return this.bean;
    }
    
    public String usuarios(){
        return "../Administrador/Usuarios/usuarios.jsp";
    }
    
    public String carreras(){
        return "../Administrador/Carreras/carreras.jsp";
    }
    
    public String profesiones(){
        return "../Administrador/Profesiones/profesiones.jsp";
    }
    
    public String claves(){
        return "../Administrador/Claves/claves.jsp";
    }
    
    public String perfil(){
        return "../Administrador/Perfil/perfil.jsp";
    }
    
    /**
     * @return the bean
     */
    public String getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(String bean) {
        this.bean = bean;
    }
    
}
