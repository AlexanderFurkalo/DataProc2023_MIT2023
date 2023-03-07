package servlet;

import Entities.Boots;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.sql.SQLException;

//import java.util.List;
import jdbc.SqlCRUD;

@WebServlet("/servlet/*")

public class servlet extends HttpServlet{
    LabCRUDInterface<Boots> crud = new SqlCRUD();
    public void init(ServletConfig config) throws ServletException {
        crud = new SqlCRUD();
    }
    public void destroy() {
        try{
            ((SqlCRUD) crud).getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //ArrayList<Boots> data = new ArrayList<Boots>();
        //data.add(CrudInterface.readEntity());
        setAccessControlHeaders(response);
        String JsonThing = new Gson().toJson(crud.read());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(JsonThing);
        out.flush();
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response) throws IOException{
        setAccessControlHeaders(response);
        Boots it = Helper.Parse(request);
        response.setContentType("application/json");
        crud.update(it.getId(), it);
        doGet(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        Boots watch = Helper.Parse(request);
        crud.create(watch);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        crud.delete(id);
        doGet(request, response);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
    }
}
