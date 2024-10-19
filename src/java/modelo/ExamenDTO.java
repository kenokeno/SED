/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moises
 */
public class ExamenDTO {
    private int Id_examen;
    private Tipo_examenDTO Tipo_examen;
    private MateriaDTO Materia;
    private PeriodoDTO Periodo;
    private CarreraDTO Carrera;
    private GrupoDTO Grupo;
    private int Unidad;
    private int Porcentaje;
    private String checkBox;
    private UsuarioDTO profesor;
    private int turno;
    private String fecha;
    private List<SeccionesDTO> secciones;

    public ExamenDTO() {
        this.Tipo_examen = new Tipo_examenDTO();
        this.Materia = new MateriaDTO();
        this.Carrera = new CarreraDTO();
        this.Grupo = new GrupoDTO();
        this.Periodo = new PeriodoDTO();
        secciones = new ArrayList<SeccionesDTO>();
        turno = 1;
    }

    /**
     * @return the Id_examen
     */
    public int getId_examen() {
        return Id_examen;
    }

    /**
     * @param Id_examen the Id_examen to set
     */
    public void setId_examen(int Id_examen) {
        this.Id_examen = Id_examen;
    }

    /**
     * @return the Tipo_examen
     */
    public Tipo_examenDTO getTipo_examen() {
        return Tipo_examen;
    }

    /**
     * @param Tipo_examen the Tipo_examen to set
     */
    public void setTipo_examen(Tipo_examenDTO Tipo_examen) {
        this.Tipo_examen = Tipo_examen;
    }

    /**
     * @return the Materia
     */
    public MateriaDTO getMateria() {
        return Materia;
    }

    /**
     * @param Materia the Materia to set
     */
    public void setMateria(MateriaDTO Materia) {
        this.Materia = Materia;
    }

    /**
     * @return the Periodo
     */
    public PeriodoDTO getPeriodo() {
        return Periodo;
    }

    /**
     * @param Periodo the Periodo to set
     */
    public void setPeriodo(PeriodoDTO Periodo) {
        this.Periodo = Periodo;
    }

    /**
     * @return the Carrera
     */
    public CarreraDTO getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(CarreraDTO Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the Grupo
     */
    public GrupoDTO getGrupo() {
        return Grupo;
    }

    /**
     * @param Grupo the Grupo to set
     */
    public void setGrupo(GrupoDTO Grupo) {
        this.Grupo = Grupo;
    }

    /**
     * @return the Unidad
     */
    public int getUnidad() {
        return Unidad;
    }

    /**
     * @param Unidad the Unidad to set
     */
    public void setUnidad(int Unidad) {
        this.Unidad = Unidad;
    }

    /**
     * @return the Porcentaje
     */
    public int getPorcentaje() {
        return Porcentaje;
    }

    /**
     * @param Porcentaje the Porcentaje to set
     */
    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    /**
     * @return the checkBox
     */
    public String getCheckBox() {
        return checkBox;
    }

    /**
     * @param checkBox the checkBox to set
     */
    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

    /**
     * @return the profesor
     */
    public UsuarioDTO getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(UsuarioDTO profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * @return the secciones
     */
    public List<SeccionesDTO> getSecciones() {
        return secciones;
    }

    /**
     * @param secciones the secciones to set
     */
    public void setSecciones(List<SeccionesDTO> secciones) {
        this.secciones = secciones;
    }
}
