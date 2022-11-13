package profesor.profesores.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@MultipartConfig(maxFileSize = 1024*1024*100)

@WebServlet(name = "ServletAlumno",  urlPatterns = {
        "/ServletAlumno",
        "/list-alumno", //get
        "/get-alumno", //Get
        "/create-alumno", //get
        "/save-alumno", //Post
        "/update-alumno", //Post
        "/delete-alumno", //Delete,
}  )
public class ServletAlumno extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        profesor.profesores.model.DaoAlumno daoAlumno = new profesor.profesores.model.DaoAlumno();
        String option = request.getServletPath();


        switch (option) {
            case "/list-alumno":

                List<profesor.profesores.model.BeanAlumno> listAlumno = daoAlumno.listAlumno();
                request.setAttribute("list", listAlumno);
                request.getRequestDispatcher("/WEB-INF/view/list-alumno.jsp").forward(request, response);

                break;



            case "/create-alumno":

                request.getRequestDispatcher("/WEB-INF/view/create-alumno.jsp").forward(request, response);

                break;


            case "/get-alumno":
                String idString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                try {
                    int id = Integer.parseInt(idString);
                    profesor.profesores.model.BeanAlumno alumno = daoAlumno.consultAlumno(id); //DAO consulta a la db
                    request.setAttribute("alumnoX", alumno);
                    request.getRequestDispatcher("/WEB-INF/view/get-alumno.jsp").forward(request,response);
                } catch (Exception e) {
                    response.sendRedirect("list-persons");
                }

                break;
            default:

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        profesor.profesores.model.DaoAlumno daoAlumno = new profesor.profesores.model.DaoAlumno();
        String option = request.getServletPath();

        switch (option) {

            case "/save-alumno":

                try {
                    //recibir valores del formulario
                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String apellidos = request.getParameter("apellidos") != null ? (request.getParameter("apellidos")) : "";
                    String fecha = request.getParameter("fecha") != null ? (request.getParameter("fecha")) : "";
                    String curp = request.getParameter("curp") != null ? (request.getParameter("curp")) : "";
                    String n_empleado = request.getParameter("n_empleado") != null ? (request.getParameter("n_empleado")) : "";
                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

                    profesor.profesores.model.BeanAlumno alumno = new profesor.profesores.model.BeanAlumno();
                    alumno.setName(name);
                    alumno.setApellidos(apellidos);
                    alumno.setFecha(date);
                    alumno.setCurp(curp);
                    alumno.setN_empleado(Integer.parseInt(n_empleado));

                    boolean result = daoAlumno.saveAlumno(alumno);
                    response.sendRedirect("list-alumno?result-save=" + (result ? "ok" : "error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-alumno");
                }
                break;



            case "/update-alumno":

                try {
                    String idUpdate = request.getParameter("id") != null ? request.getParameter("id") : "0";

                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String apellidos = request.getParameter("apellidos") != null ? (request.getParameter("apellidos")) : "";
                    String fecha = request.getParameter("fecha") != null ? (request.getParameter("fecha")) : "";
                    String curp = request.getParameter("curp") != null ? (request.getParameter("curp")) : "";
                    String matricula = request.getParameter("matricula") != null ? (request.getParameter("matricula")) : "";
                    String materia = request.getParameter("materia") != null ? (request.getParameter("materia")) : "";
                    String calificacion = request.getParameter("calificacion") != null ? (request.getParameter("calificacion")) : "";

                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

                    profesor.profesores.model.BeanAlumno alumno = new profesor.profesores.model.BeanAlumno();
                    alumno.setName(name);
                    alumno.setApellidos(apellidos);
                    alumno.setFecha(date);
                    alumno.setCurp(curp);
                    alumno.setN_empleado(Integer.parseInt(matricula));
                    alumno.setMateria(materia);
                    alumno.setCalificacion(Integer.parseInt(calificacion));

                    //  System.out.println(alumno.toString());

                    boolean result = daoAlumno.updateAlumno(alumno);


                    response.sendRedirect("list-alumno?result-update="+(result ? "ok" : "error"));


                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-alumno");
                }

                break;
            case "/delete-alumno":
                String idStringDelete = request.getParameter("name") != null ? request.getParameter("name") : "0";

                try {
                    int name = Integer.parseInt(idStringDelete);
                    boolean result = daoAlumno.deleteAlumno(name);
                    response.sendRedirect("list-alumno?result-delete="+(result ? "ok" : "error"));
                } catch (Exception e) {
                    response.sendRedirect("list-alumno");                }

                break;
            default:
                System.out.println("post");
        }

    }
}
