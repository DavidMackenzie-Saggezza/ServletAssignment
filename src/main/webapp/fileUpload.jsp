<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
    <head>
        <title>File Upload</title>
        <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            color: #D1E3DD;
            padding: 10px;
        }
        .container {
            background-color: #586F7C;
            max-width: 300px;
            margin: 5px auto;
            border-radius: 5px;
            padding: 5px;
        }
        .homeIcon {
            text-align:center;
            padding: 5px 0;
            color: #586F7C;
        }
        .heading {
            text-align: center;
            padding: 10px 0;
        }
        .formField{
            padding: 10px;
        }
        input[type=submit]{
            display: block;
            margin: auto;
            width: 50%;
            background-color: white;
            color: #586F7C;
            border-radius: 5px;
            border-color: #586F7C;
        }
        p {
            text-align:center;
        }
        .icon {
          color: #586F7C;
        }
        .files {
            text-align:center;
        }
        .files h2 {
            padding-bottom: 7px;
        }
    </style>
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
                <div class="formField">
                    <label for="overwrite">Overwrite:</label>
                    <input type="checkbox" id ="overwrite" name="overwrite">
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