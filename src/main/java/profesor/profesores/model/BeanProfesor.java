package profesor.profesores.model;

import java.util.Date;

public class BeanProfesor {
    private String name;
    private String apellidos;
    private Date fecha;
    private String curp;
    private int n_empleado;

    public BeanProfesor() {
    }

    public BeanProfesor(String name, String apellidos, Date fecha, String curp, int n_empleado) {
        this.name = name;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.curp = curp;
        this.n_empleado = n_empleado;
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

    @Override
    public String toString() {
        return "BeanProfesor{" +
                ", name='" + name + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha=" + fecha +
                ", curp='" + curp + '\'' +
                ", n_empleado=" + n_empleado +
                '}';
    }
}
