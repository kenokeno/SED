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
 * @author alfredo
 */
public class ReactivosDAO {

    private static String consultarReactivos = "SELECT * FROM reactivos where id_tema in (?) AND id_tipo = ?";

    public static List<modelo.ReactivosDTO> consultarReactivos(List<String> temas, int id_tipo) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.ReactivosDTO reactivo;
        List<modelo.ReactivosDTO> reactivos;
        String ids_temas;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultarReactivos);
            ids_temas = obtenerTemas(temas);
            stmt.setString(1, ids_temas);
            stmt.setInt(2, id_tipo);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            System.out.println("Temas: " + ids_temas + " tipo: " +  id_tipo);
            reactivos = new ArrayList<modelo.ReactivosDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                reactivo = new modelo.ReactivosDTO();
                reactivo.setId(rs.getInt("id"));
                reactivo.setPregunta(rs.getString("pregunta"));
                reactivo.setRespuesta(rs.getString("respuesta"));
                reactivo.setId_tema(rs.getInt("id_tema"));
                reactivo.setId_tipo(rs.getInt("id_tipo"));
                reactivos.add(reactivo);
            }
            return reactivos;
        } catch (Exception e) {
            System.out.println("Error: consultaExamenDAO-examen");
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
                System.out.println("Error:  consultaExamenDAO-examen-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
    
    private static String obtenerTemas(List<String> temas){
        String temas_="";
        for(String str : temas){
            temas_ += str + ",";
        }
        temas_ += "0";
        return temas_;
    }
}
