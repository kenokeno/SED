/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alfredo
 */
public class Conexion {
    private static String user = "root";
    private static String passwd = "root";
    private static String url = "localhost";
    private static String db = "sed";

    public static Connection getCon() {
        Connection con = null;
        try {
            /**CONEXION NATIVA A SQL SERVER 2005 VIA TCP/IP**/
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + url + "/" + db + "", user, passwd);
        } catch (Exception e) {
            System.out.println("Error:" + e);
            System.out.println("Conexión exitosa a MySQL");
        }
        return con;
    }
}
