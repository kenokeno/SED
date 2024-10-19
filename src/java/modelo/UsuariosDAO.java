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
 * @author MOY
 */
public class UsuariosDAO {
    // INICIAR VARIBALES GLOBALES O DE CLASE

    private static String login = "select * from usuarios where clave=? and password=?;";
    private static String modificar = "UPDATE usuarios SET nombre=?, aPaterno=?, aMaterno=?, nombreUsuario=?, password=?, mail=? ,foto=?,profesion=?  WHERE clave=?;";
    private static String nuevoUsuario = "INSERT INTO sed.usuarios (nombre, aPaterno, aMaterno, clave, nombreUsuario, password, mail, foto, profesion) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static String consultaProfeciones = "SELECT * FROM profeciones";
    private static String consultaUsuarios = "SELECT * FROM usuarios";

    public static modelo.UsuarioDTO validar(modelo.UsuarioDTO usuario) {
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
            stmt = con.prepareStatement(login);
            //PREPARAMOS LA SENTENCIA SQL
            stmt.setString(1, usuario.getClave());
            stmt.setString(2, usuario.getPassword());
            //EJECUTAMOS LA SENTENCIA SQL
            rs = stmt.executeQuery();
            // ENCAMPUSALMOS LA INFORMACION EXTRAIDA DE LA BD EN UN OBJETO
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setAPaterno(rs.getString("aPaterno"));
                usuario.setAMaterno(rs.getString("aMaterno"));
                usuario.setClave(rs.getString("clave"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setMail(rs.getString("mail"));
                usuario.setFoto(rs.getString("foto"));
                usuario.setProfesion(rs.getString("profesion"));
            }
            // REGRESAMOS EL OBJETO CON LA INFORMACION ENCAPSULADA
            return usuario;
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

    public static boolean nuevoUsuario(modelo.UsuarioDTO usuario) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;

        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(nuevoUsuario);
            //PREPARAMOS LA SENTENCIA SQL
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getAPaterno());
            stmt.setString(3, usuario.getAMaterno());
            stmt.setString(4, usuario.getClave());
            stmt.setString(5, usuario.getNombreUsuario());
            stmt.setString(6, usuario.getPassword());
            stmt.setString(7, usuario.getMail());
            stmt.setString(8, usuario.getFoto());
            stmt.setString(9, usuario.getProfesion());
            //EJECUTAMOS LA SENTENCIA SQL
            return stmt.execute();
        } catch (Exception e) {
            System.out.println("Error: nuevoUsuarioDAO-nuevo");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  nuevoUsuarioDAO-nuevo-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }

    }

    public static boolean modificar(modelo.UsuarioDTO usuario) {
        // INICIAR VARIBALES LOCALES
        Connection con = null;
        PreparedStatement stmt;
        // TRY Y CATCH
        try {
            //PREPARAMOS LA CONEXION
            // ABRIMOS CONEXION
            con = Conexion.getCon();
            // PREPARAMOS SENTENCIAS SQL
            stmt = con.prepareStatement(modificar);
            //PREPARAMOS LA SENTENCIA SQL
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getAPaterno());
            stmt.setString(3, usuario.getAMaterno());
            stmt.setString(4, usuario.getNombreUsuario());
            stmt.setString(5, usuario.getPassword());
            stmt.setString(6, usuario.getMail());
            stmt.setString(7, usuario.getFoto());
            stmt.setString(8, usuario.getProfesion());
            stmt.setString(9, usuario.getClave());
            //EJECUTAMOS LA SENTENCIA SQL
            return stmt.execute();
        } catch (Exception e) {
            System.out.println("Error: ModificaDAO-modificar");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return false;
        } finally {
            // CERRAMOS LA CONEXION A LA BD
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error:  ModificaDAO-modificar-cerrar");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
    }
}
