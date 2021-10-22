import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/httpClientTest")
public class httpClientTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestType = req.getParameter("requestType");

        if (requestType.equals("GET")) {
            myHttpClient.get();
        }
        else if (requestType.equals("PUT")) {
            myHttpClient.put();
        }
        else if (requestType.equals("DELETE")) {
            myHttpClient.delete();
        }
        else if (requestType.equals("POST")) {
            myHttpClient.post();
        }

        RequestDispatcher rd = req.getRequestDispatcher("/httpClient.html");
        rd.forward(req, resp);
    }
}
