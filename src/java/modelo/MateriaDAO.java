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
public class MateriaDAO {
    private static String consultaMateriaID = "SELECT * FROM materia where id=?";
    private static String consultaMaterias = "SELECT * FROM materia where id_carrera=?";
    
     public static modelo.MateriaDTO consultaMateriaID(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.MateriaDTO materi;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaMateriaID);
            stmt.setInt(1, id);

            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            
            
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            materi = new modelo.MateriaDTO();
           if (rs.next()) {
                
                materi.setId_materia(rs.getInt("id"));
                materi.setNombre_materia(rs.getString("nombre"));
                materi.setId_carrera(rs.getString("id_carrera"));
                materi.setUnidades(rs.getString("unidades"));
                
            }
            return materi;
        } catch (Exception e) {
            System.out.println("Error: consultaMateriaDAO-materia");
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
                System.out.println("Error:  consultaMateriaDAO-materia-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
     public static List<modelo.MateriaDTO> consultaMaterias(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<modelo.MateriaDTO> materias;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaMaterias);
            stmt.setInt(1, id);

            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            modelo.MateriaDTO materia;
            materias = new ArrayList<modelo.MateriaDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                materia = new modelo.MateriaDTO();
                materia.setId_materia(rs.getInt("id"));
                materia.setNombre_materia(rs.getString("nombre"));          
                materias.add(materia);
            }
            return materias;
        } catch (Exception e) {
            System.out.println("Error: consultaMateriaDAO-materias");
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
                System.out.println("Error:  consultaMateriaDAO-materias-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
    
}
