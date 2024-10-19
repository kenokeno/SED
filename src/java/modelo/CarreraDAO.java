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
public class CarreraDAO {
     private static String consultaCarreraID = "SELECT * FROM carrera where id=?";
     private static String consultaCarreras = "SELECT * FROM carrera";
    
     public static modelo.CarreraDTO consultaCarreraID(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.CarreraDTO carrera;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaCarreraID);
            stmt.setInt(1, id);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            
            
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            carrera = new modelo.CarreraDTO();
            if (rs.next()) {                
                carrera.setId(rs.getInt("id"));
                carrera.setNombre(rs.getString("nombre"));
                
            }
            return carrera;
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
     public static List<modelo.CarreraDTO> consultaCarreras() {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<modelo.CarreraDTO> carreras;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaCarreras);

            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            modelo.CarreraDTO carrera;
            carreras = new ArrayList<modelo.CarreraDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                carrera = new modelo.CarreraDTO();
                carrera.setId(rs.getInt("id"));
                carrera.setNombre(rs.getString("nombre"));          
                carreras.add(carrera);
            }
            return carreras;
        } catch (Exception e) {
            System.out.println("Error: consultaCarreraDAO-carreras");
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
                System.out.println("Error:  consultaCarreraDAO-carreras-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
}
