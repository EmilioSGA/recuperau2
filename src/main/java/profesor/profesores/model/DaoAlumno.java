package profesor.profesores.model;

import profesor.profesores.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAlumno {



    //Aqui haremos la conexxio´n de la base de datos

    //Esta variable es el puente (Conexión) entre la base y la app
    Connection conexion = new MySQLConnection().getConnection(); //Aqui llamamos a la funcion


    //Esta variable es para preparar la consulta (la query que deseeas en la bd)
    PreparedStatement preparedStatement;

    //En esta guardaremos todos los resultados
    ResultSet result ;

    //Listo , Ahora prepararemos las QUERY (consultas)  en dado caso lo mas comun es el CRUD

    private final String INSERT_PROFESOR = "INSERT INTO `recuperau2`.`recuperau2`(`name`,`apellidos`,`fecha`,`curp`,`n_empleado`)VALUES(?,?,?,?,?)";
    private final String GENERAL_PROFESOR = "SELECT * FROM recuperau2.recuperau2;";
    private final String CONSULT_UNIQUE = "SELECT * FROM recuperau2.recuperau2  where name = ?";
    private final String UPDATE_PROFESOR = "UPDATE `recuperau2`.`recuperau2` SET `name` = ?, `apellidos` = ?, `fecha` = ?, `curp` = ?, `n_empleado` =  ? WHERE (`name` = ?);";
    private final String DELETE_PROFESOR = "DELETE FROM `recuperau2`.`recuperau2` WHERE (`name` = ?);";




    public List<BeanAlumno> listAlumno() {
        List<BeanAlumno> listAlumnoes = new ArrayList<>();
        BeanAlumno profesor = null;
        try{

            preparedStatement = conexion.prepareStatement(GENERAL_PROFESOR);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                profesor = new BeanAlumno();
                profesor.setName(result.getString("name"));
                profesor.setApellidos(result.getString("apellidos"));
                profesor.setFecha(result.getDate("fecha"));
                profesor.setCurp(result.getString("curp"));
                profesor.setN_empleado(result.getInt("n_empleado"));
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        return listAlumnoes;
    }





    //----------------------------------------------------------------------

    public boolean saveAlumno(BeanAlumno profesor){
        try {
            preparedStatement = conexion.prepareStatement(INSERT_PROFESOR);
            preparedStatement.setString(1, profesor.getName());
            preparedStatement.setString(2, profesor.getApellidos());
            preparedStatement.setDate(3, new Date(profesor.getFecha().getTime()));
            preparedStatement.setString(4,profesor.getCurp());
            preparedStatement.setInt(5 , profesor.getN_empleado());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //------------------------------------------------------------------------------
    public BeanAlumno consultAlumno (int id){
        BeanAlumno profesor = null;
        try{

            preparedStatement = conexion.prepareStatement(CONSULT_UNIQUE);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                profesor = new BeanAlumno();
                profesor.setName(result.getString("name"));
                profesor.setApellidos(result.getString("apellidos"));
                profesor.setFecha(result.getDate("fecha"));
                profesor.setCurp(result.getString("curp"));
                profesor.setN_empleado(result.getInt("n_empleado"));

            }
            //System.out.println(song.toString());
        }catch (SQLException e){
            System.out.println(e);
        }

        return profesor;
    }




    public boolean deleteAlumno(int id) {
        try {
            preparedStatement = conexion.prepareStatement(DELETE_PROFESOR);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()==1; //1==1
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //---------------------------------------------
    public boolean updateAlumno(BeanAlumno profesor){
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_PROFESOR);
            preparedStatement.setString(1, profesor.getName());
            preparedStatement.setString(2, profesor.getApellidos());
            preparedStatement.setDate(3, new Date(profesor.getFecha().getTime()));
            preparedStatement.setString(4,profesor.getCurp());
            preparedStatement.setInt(6 , profesor.getN_empleado());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }
}
