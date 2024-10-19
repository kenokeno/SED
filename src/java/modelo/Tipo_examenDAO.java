/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import general.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moises
 */
public class Tipo_examenDAO {
    private static String consultaTipoExamenID = "SELECT * FROM tipo_examen where id_tipo_examen=?";
    private static String consultaTipos = "SELECT * FROM tipo_examen";
    
     public static modelo.Tipo_examenDTO consultaTipoExamenID(int id_tipo_examen) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.Tipo_examenDTO tipo_exam;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaTipoExamenID);
            stmt.setInt(1, id_tipo_examen);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            tipo_exam = new modelo.Tipo_examenDTO();
            if (rs.next()) {
                tipo_exam.setID_tipo_examen(rs.getInt("id_tipo_examen"));
                tipo_exam.setNombre_tipo_examen(rs.getString("nombre"));
            }
            return tipo_exam;
        } catch (Exception e) {
            System.out.println("Error: consultaTipoExamenDAO-tipo_examen");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return null;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  consultaTipoExamenDAO-tipo_examen-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
     
     public static List<modelo.Tipo_examenDTO> consultaTipos() {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<modelo.Tipo_examenDTO> tipos;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaTipos);

            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            modelo.Tipo_examenDTO tipo;
            tipos = new ArrayList<modelo.Tipo_examenDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                tipo = new modelo.Tipo_examenDTO();
                tipo.setID_tipo_examen(rs.getInt("id_tipo_examen"));
                tipo.setNombre_tipo_examen(rs.getString("nombre"));          
                tipos.add(tipo);
            }
            return tipos;
        } catch (Exception e) {
            System.out.println("Error: consultaTiposDAO-tipos");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return null;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  consultaTiposDAO-tipos-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
}
