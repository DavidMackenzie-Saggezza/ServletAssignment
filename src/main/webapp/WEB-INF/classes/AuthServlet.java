import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    Map<String, String> credentials;

    @Override
    public void init() throws ServletException {
        credentials = new HashMap<>();
        credentials.put("David", "password");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        RequestDispatcher rd;
        if (credentials.containsKey(name) && credentials.get(name).equals(password)) {
            rd = req.getRequestDispatcher("/successfulLogin.html");
        }
        else {
            rd = req.getRequestDispatcher("/failedLogin.html");
        }
        rd.forward(req, resp);
    }
}
