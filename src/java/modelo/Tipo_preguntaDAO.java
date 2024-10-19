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
public class Tipo_preguntaDAO {
    private static String consultarTipoPreguntas = "SELECT * FROM tipo_pregunta";

    public static List<modelo.Tipo_preguntaDTO> consultarTipoPreguntas() {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.Tipo_preguntaDTO tipo_pregunta;
        List<modelo.Tipo_preguntaDTO> tipo_preguntas;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultarTipoPreguntas);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            tipo_preguntas = new ArrayList<modelo.Tipo_preguntaDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                tipo_pregunta = new modelo.Tipo_preguntaDTO();
                tipo_pregunta.setId(rs.getInt("id"));
                tipo_pregunta.setNombre(rs.getString("nombre"));
                tipo_preguntas.add(tipo_pregunta);
            }
            return tipo_preguntas;
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
}
