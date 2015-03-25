package it.ale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Test_video_360Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/360-video.jsp");

        try {
            view.forward(req, resp);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            resp.setContentType("text/plain");
            resp.getWriter().println("ServletException: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
