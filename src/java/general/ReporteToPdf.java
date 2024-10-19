/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

/**
 *
 * @author alfredo
 */
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;

public class ReporteToPdf {

    public static boolean generarPdf(String jasper,
            Map<String, Object> parameters) {

        Connection conexion = null;
        try {

            conexion = Conexion.getCon();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) context.getExternalContext().getContext();
        File reportFile = new File(sc.getRealPath(jasper));
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        byte[] bytes = null;
        try {
            bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conexion);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            outputStream.close();
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
