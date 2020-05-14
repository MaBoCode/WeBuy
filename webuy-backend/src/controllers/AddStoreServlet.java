package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StoreServlet")
public class AddStoreServlet extends HttpServlet {

    public boolean isInputValid(String storeName) {
        return storeName != null && !storeName.isEmpty();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String storeName = request.getParameter("storeName");

        if (!isInputValid(storeName)) {
            ;
        }

        String query = "INSERT INTO (";

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
