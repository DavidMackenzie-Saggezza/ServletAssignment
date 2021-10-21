import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Files.createDirectories(Paths.get("src\\main\\webapp\\WEB-INF\\Uploads").toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        List<String> fileNames = new ArrayList<String>();
        File[] files = new File(Paths.get("src\\main\\webapp\\WEB-INF\\Uploads\\").toAbsolutePath().toString()).listFiles();
        for (File file : files) {
            fileNames.add(file.getName());
        }



        if (req.getParameter("overwrite") != null && Files.exists(Paths.get("src\\main\\webapp\\WEB-INF\\Uploads\\" + fileName).toAbsolutePath())) {
            Files.copy(fileContent, Paths.get("src\\main\\webapp\\WEB-INF\\Uploads\\" + fileName).toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
            req.setAttribute("fileAction", "overwritten");
        }
        else if (req.getParameter("overwrite") == null && Files.exists(Paths.get("src\\main\\webapp\\WEB-INF\\Uploads\\" + fileName).toAbsolutePath())) {
            req.setAttribute("fileAction", "notOverwritten");
        }
        else {
            Files.copy(fileContent, Paths.get("src\\main\\webapp\\WEB-INF\\Uploads\\" + fileName).toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
            fileNames.add(fileName);
            req.setAttribute("fileAction", "written");
        }

        req.setAttribute("files", fileNames);
        RequestDispatcher rd = req.getRequestDispatcher("/fileUpload.jsp");
        rd.forward(req, resp);
    }
}
