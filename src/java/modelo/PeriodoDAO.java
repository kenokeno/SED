/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import general.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author moises
 */
public class PeriodoDAO {
    private static String consultaPeriodoID = "SELECT * FROM periodo";
    
     public static modelo.PeriodoDTO consultaPeriodoID() {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.PeriodoDTO period;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaPeriodoID);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            period = new modelo.PeriodoDTO();
            if (rs.next()) {
                period.setId(rs.getInt("id"));
                period.setInicio(rs.getString("inicio"));
                period.setFin(rs.getString("fin"));
            }
            return period;
        } catch (Exception e) {
            System.out.println("Error: consultaPeriodoDAO-periodo");
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
                System.out.println("Error:  consultaPeriodoDAO-periodo-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }    
}
