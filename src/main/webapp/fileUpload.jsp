<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
    <head>
        <title>File Upload</title>
        <link rel="stylesheet" href="css/site.css">
    </head>
    <body>
        <div class="homeIcon">
            <a href="index.jsp">
                <i class="fas fa-home fa-2x icon"></i>
            </a>
        </div>
        <div class="container">
            <h1 class="heading">
                File Upload With Servlets
            </h1>
            <form action="fileUpload" method="POST" enctype="multipart/form-data">
                <div class="formField">
                    <input type="file" id="file" name="file" required>
                </div>
                <div class="formField checkBox">
                    <label for="overwrite" >Overwrite:</label>
                    <span><input type="checkbox" id ="overwrite" name="overwrite"></span>
                </div>
                <div class="formField">
                    <input type="submit" value="Upload">
                </div>
            </form>
            <p>
                <%
                    String fileAction = (String) request.getAttribute("fileAction");
                    if (fileAction != null) {
                        if (fileAction.equals("overwritten")) {
                            out.println("File is Overwritten");
                        }
                        else if (fileAction.equals("notOverwritten")) {
                            out.println("File already exist and Overwrite not checked.");
                        }
                        else if (fileAction.equals("written")) {
                            out.println("File written.");
                        }
                    }
                %>
            </p>
        </div>
        <div class="container files">
            <h2>Files Uploaded</h2>
            <c:forEach items="${files}" var="file">
                ${file}<br>
            </c:forEach>
        </div>


    </body>
    <script
            src="https://kit.fontawesome.com/790277f21c.js"
            crossorigin="anonymous">
    </script>
</html>