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
 * @author MOY
 */
public class RolesDAO {

    private static String consultaClaves = "SELECT * FROM roles";
    private static String filtrarClaves = "SELECT * FROM roles WHERE Clave LIKE CONCAT('%', ? ,'%')";
    private static String nuevaClave = "INSERT INTO roles (clave, rol) VALUES (?, ?)";
    private static String eliminarClave = "DELETE FROM roles WHERE Id = ?";

    public static List<modelo.RolesDTO> consultaClaves(List<modelo.RolesDTO> roles) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;

        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(consultaClaves);

            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            modelo.RolesDTO rol;
            roles = new ArrayList<modelo.RolesDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                rol = new modelo.RolesDTO();
                rol.setId(rs.getInt("Id"));
                rol.setClave(rs.getString("Clave"));
                rol.setRol(rs.getString("Rol"));
                rol.setCheckBox(general.Utilerias.checkBox(rs.getString("Id")));
                roles.add(rol);
            }
            return roles;
        } catch (Exception e) {
            System.out.println("Error: consultaClavesDAO-claves");
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
                System.out.println("Error:  consultaClavesDAO-claves-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }

    public static List<modelo.RolesDTO> filtrarClaves(modelo.FiltroDTO filtros) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(filtrarClaves);
            stmt.setString(1, filtros.getFiltro1());
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            modelo.RolesDTO rol;
            List<modelo.RolesDTO> roles = new ArrayList<modelo.RolesDTO>();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            for (int i = 0; rs.next(); i++) {
                rol = new modelo.RolesDTO();
                rol.setId(rs.getInt("Id"));
                rol.setClave(rs.getString("Clave"));
                rol.setRol(rs.getString("Rol"));
                rol.setCheckBox(general.Utilerias.checkBox(rs.getString("Id")));
                roles.add(rol);
            }
            // REGRESAMOS EL OBJETO CON LA INFORMACION ENCAPSULADA
            return roles;
        } catch (Exception e) {
            System.out.println("Error: consultaClavesDAO-claves");
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
                System.out.println("Error:  consultaClavesDAO-claves-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }

    public static int nuevaClave(modelo.RolesDTO clave) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(nuevaClave);
            stmt.setString(1, clave.getClave());
            stmt.setString(2, clave.getRol());
            //EJECUTAMOS LA SENTENCIA SQL
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: nuevasClavesDAO-claves");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return 0;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  nuevasClavesDAO-claves-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }

    public static int eliminarClaves(String claves) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            System.out.println(claves.split(",").length);
            for (String id_clave : claves.split(",")) {
                stmt = con.prepareStatement(eliminarClave);
                stmt.setString(1, id_clave);
                //EJECUTAMOS LA SENTENCIA SQL
                stmt.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Error: eliminarClavesDAO-claves");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return 0;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  eliminarClavesDAO-claves-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
}
