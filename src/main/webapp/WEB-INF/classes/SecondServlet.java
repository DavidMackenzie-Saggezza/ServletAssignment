import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter writer = resp.getWriter();
        writer.println("You have reached the second servlet");
        writer.println("This servlet is calling Fibonacci method in wrapper class with n = 10 and printing results");
        WrapperClass wrapperClass = new WrapperClass(req);
       for (Integer num: wrapperClass.fibonacci(10)) {
           writer.println(num);
       }
    }
}
