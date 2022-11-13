package profesor.profesores.model;

import java.util.Date;

public class BeanAlumno {
    private String name;
    private String apellidos;
    private Date fecha;
    private String curp;
    private int n_empleado;
    private String materia;
    private int calificacion;

    public BeanAlumno() {
    }

    public BeanAlumno(String name, String apellidos, Date fecha, String curp, int n_empleado, String materia, int calificacion) {
        this.name = name;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.curp = curp;
        this.n_empleado = n_empleado;
        this.materia = materia;
        this.calificacion = calificacion;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getN_empleado() {
        return n_empleado;
    }

    public void setN_empleado(int n_empleado) {
        this.n_empleado = n_empleado;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "BeanAlumno{" +
                ", name='" + name + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha=" + fecha +
                ", curp='" + curp + '\'' +
                ", n_empleado=" + n_empleado +
                ", materia=" + materia +
                ", calificacion=" + calificacion +
                '}';
    }
}
