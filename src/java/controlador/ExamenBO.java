/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.faces.model.SelectItem;
import modelo.ExamenDAO;
import modelo.MateriaDAO;

/**
 *
 * @author moises
 */
public class ExamenBO implements Serializable {

    private List<modelo.ExamenDTO> examenes;
    private modelo.ExamenDTO examen;
    private List<SelectItem> lstTipos;
    private List<SelectItem> lstCarreras;
    private List<SelectItem> lstMaterias;
    private List<SelectItem> lstGrupos;
    private List<SelectItem> lstUnidades;
    private List<SelectItem> lstTemas;
    private List<SelectItem> lstTipoPreguntas;
    private List<SelectItem> lstPreguntas;
    private modelo.UsuarioDTO usuario;
    private List<modelo.SeccionesDTO> lstSecciones;
    private List<String> temas_seccion;
    private int tipo_pregunta;

    public ExamenBO() {
        usuario = (modelo.UsuarioDTO) general.SessionVariables.getUsuarioLoginDatos();
        examenes = ExamenDAO.consultarExamenes(usuario.getId());
    }

    public String nuevo() {
        examen = new modelo.ExamenDTO();
        examen.setPeriodo(modelo.PeriodoDAO.consultaPeriodoID());
        examen.setProfesor(usuario);
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        examen.setFecha(format.format(date));
        llenarCombos();
        generarSecciones();
        return "examen_nuevo.jsp";
    }

    public String filtrarCombos() {
        filtrarMaterias();
        filtrarGrupos();
        return "";
    }

    public String filtrarMaterias() {
        lstMaterias = new ArrayList<SelectItem>();
        List<modelo.MateriaDTO> lst = MateriaDAO.consultaMaterias(examen.getCarrera().getId());
        ListIterator<modelo.MateriaDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.MateriaDTO actual = (modelo.MateriaDTO) i.next();
            lstMaterias.add(new SelectItem(actual.getId_materia(), actual.getNombre_materia()));
        }
        return "";
    }

    public String filtrarGrupos() {
        setLstGrupos(new ArrayList<SelectItem>());
        List<modelo.GrupoDTO> lst = modelo.GrupoDAO.consultaGrupos(examen.getCarrera().getId());
        ListIterator<modelo.GrupoDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.GrupoDTO actual = (modelo.GrupoDTO) i.next();
            getLstGrupos().add(new SelectItem(actual.getId_grupo(), actual.getNombre()));
        }
        return "";
    }

    private void llenarCombos() {
        comboTipos();
        comboCarreras();
    }

    private void comboTipos() {
        lstTipos = new ArrayList<SelectItem>();
        List<modelo.Tipo_examenDTO> lst = modelo.Tipo_examenDAO.consultaTipos();
        ListIterator<modelo.Tipo_examenDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.Tipo_examenDTO actual = (modelo.Tipo_examenDTO) i.next();
            lstTipos.add(new SelectItem(actual.getID_tipo_examen(), actual.getNombre_tipo_examen()));
        }
    }

    private void comboCarreras() {
        lstCarreras = new ArrayList<SelectItem>();
        List<modelo.CarreraDTO> lst = modelo.CarreraDAO.consultaCarreras();
        ListIterator<modelo.CarreraDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.CarreraDTO actual = (modelo.CarreraDTO) i.next();
            lstCarreras.add(new SelectItem(actual.getId(), actual.getNombre()));
        }
    }

    public String filtrarUnidades() {
        int unidades;
        lstUnidades = new ArrayList<SelectItem>();
        modelo.MateriaDTO materia = modelo.MateriaDAO.consultaMateriaID(examen.getMateria().getId_materia());
        examen.setMateria(materia);
        unidades = Integer.parseInt(materia.getUnidades());
        for (int i = 1; i <= unidades; i++) {
            lstUnidades.add(new SelectItem("" + i, "" + i));
        }
        return "";
    }

    private void generarSecciones() {
        setLstSecciones(new ArrayList<modelo.SeccionesDTO>());
        modelo.SeccionesDTO seccion = new modelo.SeccionesDTO();
        seccion.setNumero(1);
        seccion.setReactivos(new ArrayList<modelo.ReactivosDTO>());
        getLstSecciones().add(seccion);
    }

    public String agregarSeccion() {
        modelo.SeccionesDTO seccion = new modelo.SeccionesDTO();
        int ultimo = getLstSecciones().size();
        seccion.setNumero(examen.getSecciones().get(ultimo).getNumero() + 1);
        seccion.setReactivos(new ArrayList<modelo.ReactivosDTO>());
        examen.getSecciones().add(seccion);
        return "";
    }

    public String temas() {
        listaTemas();
        comboTipoPreguntas();
        return "secciones";
    }

    private void listaTemas() {
        lstTemas = new ArrayList<SelectItem>();
        List<modelo.TemasDTO> lst = modelo.TemasDAO.consultar(examen.getMateria().getId_materia(), examen.getUnidad());
        ListIterator<modelo.TemasDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.TemasDTO actual = (modelo.TemasDTO) i.next();
            lstTemas.add(new SelectItem(actual.getId(), actual.getNombre()));
        }
    }

    private void comboTipoPreguntas() {
        lstTipoPreguntas = new ArrayList<SelectItem>();
        List<modelo.Tipo_preguntaDTO> lst = modelo.Tipo_preguntaDAO.consultarTipoPreguntas();
        ListIterator<modelo.Tipo_preguntaDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.Tipo_preguntaDTO actual = (modelo.Tipo_preguntaDTO) i.next();
            lstTipoPreguntas.add(new SelectItem(actual.getId(), actual.getNombre()));
        }
    }

    public String preguntas() {
        lstPreguntas = new ArrayList<SelectItem>();
        for(String str : temas_seccion){
            System.out.println(str);
        }
        List<modelo.ReactivosDTO> lst = modelo.ReactivosDAO.consultarReactivos(temas_seccion, this.tipo_pregunta);
        ListIterator<modelo.ReactivosDTO> i = lst.listIterator();
        while (i.hasNext()) {
            modelo.ReactivosDTO actual = (modelo.ReactivosDTO) i.next();
            lstPreguntas.add(new SelectItem(actual.getId(), actual.getPregunta()));
        }
        return "reactivos";
    }

    /**
     * @return the examenes
     */
    public List<modelo.ExamenDTO> getExamenes() {
        return examenes;
    }

    /**
     * @param examenes the examenes to set
     */
    public void setExamenes(List<modelo.ExamenDTO> examenes) {
        this.examenes = examenes;
    }

    /**
     * @return the examen
     */
    public modelo.ExamenDTO getExamen() {
        return examen;
    }

    /**
     * @param examen the examen to set
     */
    public void setExamen(modelo.ExamenDTO examen) {
        this.examen = examen;
    }

    /**
     * @return the lstCarreras
     */
    public List<SelectItem> getLstCarreras() {
        return lstCarreras;
    }

    /**
     * @param lstCarreras the lstCarreras to set
     */
    public void setLstCarreras(List<SelectItem> lstCarreras) {
        this.lstCarreras = lstCarreras;
    }

    /**
     * @return the lstMaterias
     */
    public List<SelectItem> getLstMaterias() {
        return lstMaterias;
    }

    /**
     * @param lstMaterias the lstMaterias to set
     */
    public void setLstMaterias(List<SelectItem> lstMaterias) {
        this.lstMaterias = lstMaterias;
    }

    /**
     * @return the lstTipos
     */
    public List<SelectItem> getLstTipos() {
        return lstTipos;
    }

    /**
     * @param lstTipos the lstTipos to set
     */
    public void setLstTipos(List<SelectItem> lstTipos) {
        this.lstTipos = lstTipos;
    }

    /**
     * @return the lstGrupos
     */
    public List<SelectItem> getLstGrupos() {
        return lstGrupos;
    }

    /**
     * @param lstGrupos the lstGrupos to set
     */
    public void setLstGrupos(List<SelectItem> lstGrupos) {
        this.lstGrupos = lstGrupos;
    }

    /**
     * @return the lstUnidades
     */
    public List<SelectItem> getLstUnidades() {
        return lstUnidades;
    }

    /**
     * @param lstUnidades the lstUnidades to set
     */
    public void setLstUnidades(List<SelectItem> lstUnidades) {
        this.lstUnidades = lstUnidades;
    }

    /**
     * @return the lstSecciones
     */
    public List<modelo.SeccionesDTO> getLstSecciones() {
        return lstSecciones;
    }

    /**
     * @param lstSecciones the lstSecciones to set
     */
    public void setLstSecciones(List<modelo.SeccionesDTO> lstSecciones) {
        this.lstSecciones = lstSecciones;
    }

    /**
     * @return the lstTemas
     */
    public List<SelectItem> getLstTemas() {
        return lstTemas;
    }

    /**
     * @param lstTemas the lstTemas to set
     */
    public void setLstTemas(List<SelectItem> lstTemas) {
        this.lstTemas = lstTemas;
    }

    /**
     * @return the lstTipoPreguntas
     */
    public List<SelectItem> getLstTipoPreguntas() {
        return lstTipoPreguntas;
    }

    /**
     * @param lstTipoPreguntas the lstTipoPreguntas to set
     */
    public void setLstTipoPreguntas(List<SelectItem> lstTipoPreguntas) {
        this.lstTipoPreguntas = lstTipoPreguntas;
    }

    /**
     * @return the lstPreguntas
     */
    public List<SelectItem> getLstPreguntas() {
        return lstPreguntas;
    }

    /**
     * @param lstPreguntas the lstPreguntas to set
     */
    public void setLstPreguntas(List<SelectItem> lstPreguntas) {
        this.lstPreguntas = lstPreguntas;
    }

    /**
     * @return the tipo_pregunta
     */
    public int getTipo_pregunta() {
        return tipo_pregunta;
    }

    /**
     * @param tipo_pregunta the tipo_pregunta to set
     */
    public void setTipo_pregunta(int tipo_pregunta) {
        this.tipo_pregunta = tipo_pregunta;
    }

    /**
     * @return the temas_seccion
     */
    public List<String> getTemas_seccion() {
        return temas_seccion;
    }

    /**
     * @param temas_seccion the temas_seccion to set
     */
    public void setTemas_seccion(List<String> temas_seccion) {
        this.temas_seccion = temas_seccion;
    }
}
