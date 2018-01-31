package ru.fab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fab.util.GoodsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoodsServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GoodsServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        log.info("Logged user by id {}", userId);
        request.setAttribute("goodsList", GoodsUtil.getAll());
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("get all Goods");
        request.setAttribute("goodsList", GoodsUtil.getAll());
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
    }
}
