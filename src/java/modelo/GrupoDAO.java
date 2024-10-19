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
public class GrupoDAO {
   private static String consultaGrupoID = "SELECT * FROM grupo where id=?";
   private static String consultaGrupos = "SELECT * FROM grupo where id_carrera = ?";
   
     public static modelo.GrupoDTO consultaGrupoID(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.GrupoDTO grup;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaGrupoID);
            stmt.setInt(1, id); 
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            
            
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            grup = new modelo.GrupoDTO();
            if (rs.next()) {
                
                grup.setId_grupo(rs.getInt("id"));
                grup.setNombre(rs.getString("nombre"));
                grup.setId_carrera(rs.getString("id_carrera"));                              
                
            }
            return grup;
        } catch (Exception e) {
            System.out.println("Error: consultaGrupoDAO-grupo");
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
                System.out.println("Error:  consultaGrupoDAO-grupo-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
     
     public static List<modelo.GrupoDTO> consultaGrupos(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.GrupoDTO grup;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaGrupos);
            stmt.setInt(1, id);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            
            List lista = new ArrayList<modelo.GrupoDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            while (rs.next()) {
                grup = new modelo.GrupoDTO();    
                grup.setId_grupo(rs.getInt("id"));
                grup.setNombre(rs.getString("nombre"));
                grup.setId_carrera(rs.getString("id_carrera"));                              
                lista.add(grup);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error: consultaGrupoDAO-grupo");
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
                System.out.println("Error:  consultaGrupoDAO-grupo-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
     
}
