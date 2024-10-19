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
public class TemasDAO {
    private static String consultaTemas = "SELECT * FROM temas INNER JOIN tema_materia "
            + "ON tema_materia.idMateria= ? "
            + "AND temas.id = tema_materia.idTema "
            + "AND temas.unidad = ?";

    public static List<modelo.TemasDTO> consultar(int id_materia, int unidad) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        List<modelo.TemasDTO> temas;
        modelo.TemasDTO tema;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaTemas);
            //PREPARAMOS LA SENTENCIA SQL
            stmt.setInt(1, id_materia);
            stmt.setInt(2, unidad);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            temas = new ArrayList<modelo.TemasDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            while (rs.next()) {
                tema = new modelo.TemasDTO();
                tema.setId(rs.getInt("id"));
                tema.setNombre(rs.getString("nombre"));
                tema.setUnidad(rs.getInt("unidad"));
                temas.add(tema);
            }
            // REGRESAMOS EL OBJETO CON LA INFORMACION ENCAPSULADA
            return temas;
        } catch (Exception e) {
            System.out.println("Error: LoginDAO-validar");
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
                System.out.println("Error: LoginDAO-validar-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
}
