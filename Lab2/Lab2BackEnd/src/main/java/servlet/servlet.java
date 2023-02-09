package servlet;

import Entities.Boots;
import Crud.CrudInterface;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")

public class servlet extends HttpServlet{
    ServletConfigInterface servletConfig;
    CrudInterface CrudInterface;
    public servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.CrudInterface = servletConfig.getCrud();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Boots> data = new ArrayList<Boots>();
        data.add(CrudInterface.readEntity());
        String JsonThing = new Gson().toJson(data);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(JsonThing);
        out.flush();
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        int size = Integer.parseInt(request.getParameter("size"));
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");

        CrudInterface.updateEntity(new Boots(name,size,price,image));
    }
}
