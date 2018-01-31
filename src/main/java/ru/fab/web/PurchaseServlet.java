package ru.fab.web;

import ru.fab.util.PurchaseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PurchaseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // request.setAttribute("purchaseList", PurchaseUtil.getAll());
        request.getRequestDispatcher("/purchases.jsp").forward(request, response);
    }
}
