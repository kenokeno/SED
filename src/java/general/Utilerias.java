/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

/**
 *
 * @author alfredo
 */
public class Utilerias {
    public static String checkBox(String id) {
        StringBuilder chkbox = new StringBuilder();
        chkbox.append("<center>").append("<input type = 'checkbox' ").append(
                "name = 'nombre_").append(id).append("' ").append(
                "id = 'id_").append(id).append("' ").append("value = '")
                .append(id)
                .append("' />").append("</center>");
        return chkbox.toString();
    }
    
    public static boolean esValidoEliminarCheckBox(String seleccionados) {
        if(seleccionados!=null && seleccionados.isEmpty()){
            return false;
        }
        return true;
    }
    
    public static boolean esValidoEditarCheckBox(String seleccionados) {
        if(seleccionados==null || seleccionados.isEmpty() || seleccionados.split(",").length>1){
            return false;
        }
        return true;
    }
    
    public static String mensajeErrorEditar(){
        return "* Debe seleccionar solo un registro de la lista.";
    }
    
    public static String mensajeErrorEliminar(){
        return "* Debe seleccionar al menos un registro de la lista.";
    }
}
