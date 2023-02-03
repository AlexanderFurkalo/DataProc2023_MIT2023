package servlet;

import Entities.Boots;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet")

public class servlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Boots boots = new Boots("Name",40,4000, "assets/boot1.JPG");
        ArrayList<Boots> data = new ArrayList<Boots>();
        data.add(boots);
        String JsonThing = new Gson().toJson(data);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(JsonThing);
        out.flush();
    }
}
