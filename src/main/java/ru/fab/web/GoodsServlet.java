package ru.fab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.fab.util.GoodsUtil;
import ru.fab.web.goods.GoodsAdminRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoodsServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GoodsServlet.class);

    private ConfigurableApplicationContext springContext;
    private GoodsAdminRestController controller;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        controller = springContext.getBean(GoodsAdminRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        log.info("Logged user by id {}", userId);
        request.setAttribute("goodsList", controller.getAll());
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("get all Goods");
        request.setAttribute("goodsList", controller.getAll());
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
    }
}
