package controller;

import model.Task;
import service.TaskService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;


@WebServlet (name = "MainController", value = "/task")
public class MainController extends HttpServlet {

    @Inject
    private TaskService taskService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getRequestDispatcher("WEB-INF/main.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Object attribute = session.getAttribute("taskList");

        Collection <Task> tasksList =(Collection<Task>) attribute;

        if (tasksList == null) {
            tasksList = new LinkedList<>();
        }


        String status = request.getParameter("status");
        String content = request.getParameter("content");
        LocalDate date = LocalDate.parse(request.getParameter("date"));

        Task task = new Task();
        task.setStatus(status);
        Map<Integer, String> optionsMap = task.getOptionsMap();


        task.setDate(date);
        task.setContent(content);

        tasksList.add(task);

        session.setAttribute("taskList",tasksList);

        response.sendRedirect("/list");
    }
}
