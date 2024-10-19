package general;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionVariables {

    public static String getUsuarioLogin() {
        ExternalContext G = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) G.getSession(true);
        return (String) session.getAttribute("login");
    }

    public static void setUsuarioLogin(String nombreUsuario) {
        ExternalContext G = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) G.getSession(true);
        session.setAttribute("login", nombreUsuario);
    }

    public static Object getUsuarioLoginDatos() {
        ExternalContext G = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) G.getSession(true);
        return session.getAttribute("datos");
    }

    public static void setUsuarioLoginDatos(Object dato) {
        ExternalContext G = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) G.getSession(true);
        session.setAttribute("datos", dato);
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
}
