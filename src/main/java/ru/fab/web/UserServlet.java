package ru.fab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fab.model.Role;
import ru.fab.model.User;
import ru.fab.repository.mock.InMemoryUserRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    private InMemoryUserRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserRepository();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        User user = new User(id.isEmpty() ? null : Integer.valueOf(id),
                request.getParameter("name"),
                request.getParameter("password"),
                Role.ROLE_USER);
        log.info(user.isNew() ? "Create {}" : "Update {}", user);
        repository.save(user);
        response.sendRedirect("users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            log.debug("getAll");
            request.setAttribute("userList", repository.getAll());
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            Integer id = getId(request);
            log.debug("delete {}", id);
            repository.delete(id);
            response.sendRedirect("users");
        } else {
            final User user = action.equals("create") ?
                    new User("", "", Role.ROLE_USER) :
                    repository.get(getId(request));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
        }


    }

    private Integer getId(HttpServletRequest request) {
        String param = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(param);
    }
}
