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
public class DocenteBO implements Serializable {
    private String bean;
    
    public DocenteBO(){
        bean = "../Docentes/principal.jsp";
    }

    public String manage(String bean){
        if(bean.equalsIgnoreCase("perfil"))
            this.bean = "Perfil/perfil.jsp";
        if(bean.equalsIgnoreCase("gestion"))
            this.bean= "Gestion/gestion.jsp";
        return this.bean;
        
    }
    
    
    public String perfil(){
        return "../Docente/Perfil/perfil.jsp";
    }
    public String gestion(){
        return "../Docentes/Gestion/gestion.jsp";
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