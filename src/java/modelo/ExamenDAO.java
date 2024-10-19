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
public class ExamenDAO {
    private static String consultarExamenes = "SELECT * FROM examen where id_usuario = ? ";
    
     public static List<modelo.ExamenDTO> consultarExamenes(int id) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        modelo.ExamenDTO exam;
        List<modelo.ExamenDTO> examen;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultarExamenes);
            stmt.setInt(1, id);
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            examen = new ArrayList<modelo.ExamenDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                exam = new modelo.ExamenDTO();
                exam.setId_examen(rs.getInt("id_examen"));
                exam.setPorcentaje(rs.getInt("porcentaje"));
                exam.setUnidad(rs.getInt("unidad"));
                exam.setTipo_examen(Tipo_examenDAO.consultaTipoExamenID(rs.getInt("id_tipo_examen")));
                exam.setMateria(MateriaDAO.consultaMateriaID(rs.getInt("id_materia")));
                exam.setCarrera(CarreraDAO.consultaCarreraID(rs.getInt("id_carrera")));
                exam.setGrupo(GrupoDAO.consultaGrupoID(rs.getInt("id_grupo")));
                exam.setPeriodo(PeriodoDAO.consultaPeriodoID());
                exam.setCheckBox(general.Utilerias.checkBox(rs.getString("id_examen")));
                examen.add(exam);
            }
            return examen;
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
