import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if (req.getParameter(paramName).isEmpty()) {
                req.removeAttribute(paramName);
            }
            else {
                req.setAttribute(paramName, req.getParameter(paramName));
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher("listeners.html");
        rd.forward(req, resp);
    }
}
