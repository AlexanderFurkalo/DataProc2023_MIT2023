package servlet;

import Entities.Boots;
import Crud.CrudInterface;
import Mock.Data;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;

import java.util.List;

@WebServlet("/servlet/*")

public class servlet extends HttpServlet{
    private List<Boots> listd = new Data().getData();
    ServletConfigInterface servletConfig;
    CrudInterface CrudInterface;
    public servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.CrudInterface = servletConfig.getCrud();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //ArrayList<Boots> data = new ArrayList<Boots>();
        //data.add(CrudInterface.readEntity());
        String JsonThing = new Gson().toJson(listd);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        out.print(JsonThing);
        out.flush();
    }

    protected void doPut (HttpServletRequest request, HttpServletResponse response) throws IOException{
        //int id = Integer.parseInt(request.getParameter("id"));
        //String name = request.getParameter("name");
        //int size = Integer.parseInt(request.getParameter("size"));
        //int price = Integer.parseInt(request.getParameter("price"));
        //String image = request.getParameter("image");
        //CrudInterface.updateEntity(new Boots(id,name,size,price,image));
        Boots watch = CrudInterface.watchParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = CrudInterface.getIndexByWatchId(id, listd);
        listd.set(index, watch);
        doGet(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Boots watch = CrudInterface.watchParse(request);
        watch.setId(CrudInterface.getNextId(listd));
        listd.add(watch);
        doGet(request, response);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = CrudInterface.getIndexByWatchId(id, listd);
        listd.remove(index);
        doGet(request, response);
    }
}
