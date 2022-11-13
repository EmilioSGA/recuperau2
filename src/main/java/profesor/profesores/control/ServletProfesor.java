package profesor.profesores.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@MultipartConfig(maxFileSize = 1024*1024*100)

@WebServlet(name = "ServletProfesor",  urlPatterns = {
        "/ServletProfesor",
        "/list-profesor", //get
        "/get-profesor", //Get
        "/create-profesor", //get
        "/save-profesor", //Post
        "/update-profesor", //Post
        "/delete-profesor", //Delete,
}  )
public class ServletProfesor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        profesor.profesores.model.DaoProfesor daoProfesor = new profesor.profesores.model.DaoProfesor();
        String option = request.getServletPath();


        switch (option) {
            case "/list-profesor":

                List<profesor.profesores.model.BeanProfesor> listProfesor = daoProfesor.listProfesor();
                request.setAttribute("list", listProfesor);
                request.getRequestDispatcher("/WEB-INF/view/list-profesor.jsp").forward(request, response);

                break;



            case "/create-profesor":

                request.getRequestDispatcher("/WEB-INF/view/create-profesor.jsp").forward(request, response);

                break;


            case "/get-profesor":
                String idString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                try {
                    int id = Integer.parseInt(idString);
                    profesor.profesores.model.BeanProfesor profesor = daoProfesor.consultProfesor(id); //DAO consulta a la db
                    request.setAttribute("profesorX", profesor);
                    request.getRequestDispatcher("/WEB-INF/view/get-profesor.jsp").forward(request,response);
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

        profesor.profesores.model.DaoProfesor daoProfesor = new profesor.profesores.model.DaoProfesor();
        String option = request.getServletPath();

        switch (option) {

            case "/save-profesor":

                try {
                    //recibir valores del formulario
                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String apellidos = request.getParameter("apellidos") != null ? (request.getParameter("apellidos")) : "";
                    String fecha = request.getParameter("fecha") != null ? (request.getParameter("fecha")) : "";
                    String curp = request.getParameter("curp") != null ? (request.getParameter("curp")) : "";
                    String n_empleado = request.getParameter("n_empleado") != null ? (request.getParameter("n_empleado")) : "";
                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

                    profesor.profesores.model.BeanProfesor profesor = new profesor.profesores.model.BeanProfesor();
                    profesor.setName(name);
                    profesor.setApellidos(apellidos);
                    profesor.setFecha(date);
                    profesor.setCurp(curp);
                    profesor.setN_empleado(Integer.parseInt(n_empleado));

                    boolean result = daoProfesor.saveProfesor(profesor);
                    response.sendRedirect("list-profesor?result-save=" + (result ? "ok" : "error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-profesor");
                }
                break;



            case "/update-profesor":

                try {
                    String idUpdate = request.getParameter("id") != null ? request.getParameter("id") : "0";

                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String apellidos = request.getParameter("apellidos") != null ? (request.getParameter("apellidos")) : "";
                    String fecha = request.getParameter("fecha") != null ? (request.getParameter("fecha")) : "";
                    String curp = request.getParameter("curp") != null ? (request.getParameter("curp")) : "";
                    String n_empleado = request.getParameter("n_empleado") != null ? (request.getParameter("n_empleado")) : "";
                    String ranking = request.getParameter("ranking") != null ? (request.getParameter("ranking")) : "";

                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

                    profesor.profesores.model.BeanProfesor profesor = new profesor.profesores.model.BeanProfesor();
                    profesor.setName(name);
                    profesor.setApellidos(apellidos);
                    profesor.setFecha(date);
                    profesor.setCurp(curp);
                    profesor.setN_empleado(Integer.parseInt(n_empleado));

                  //  System.out.println(profesor.toString());

                    boolean result = daoProfesor.updateProfesor(profesor);


                    response.sendRedirect("list-profesor?result-update="+(result ? "ok" : "error"));


                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-profesor");
                }

                break;
            case "/delete-profesor":
                String idStringDelete = request.getParameter("name") != null ? request.getParameter("name") : "0";

                try {
                    int name = Integer.parseInt(idStringDelete);
                    boolean result = daoProfesor.deleteProfesor(name);
                    response.sendRedirect("list-profesor?result-delete="+(result ? "ok" : "error"));
                } catch (Exception e) {
                    response.sendRedirect("list-profesor");                }

                break;
            default:
                System.out.println("post");
        }

    }
}
