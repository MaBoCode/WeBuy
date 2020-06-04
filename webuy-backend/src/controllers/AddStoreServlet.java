package controllers;

import models.Store;
import utils.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/AddStoreServlet")
public class AddStoreServlet extends HttpServlet {

    private DataSource dataSource = null;

    public boolean isInputValid(String storeName) {
        return storeName != null && !storeName.isEmpty();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String storeName = request.getParameter("storeName");

        if (!isInputValid(storeName)) {
            PrintWriter out = response.getWriter();
            out.println("<p>Invalid input</p>");
            return;
        }

        dataSource = DataSource.getInstance();

        try {
            dataSource.addStore(storeName, "test");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
