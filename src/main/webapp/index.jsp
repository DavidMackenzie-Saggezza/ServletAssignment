<!DOCTYPE html>
<html>
    <head>
        <title>David's Servlet Assignment</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                padding: 10px;
                color: #D1E3DD;
            }
            .container {
                background-color: #586F7C;
                max-width: 500px;
                margin:auto;
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
            ul{
                text-align:center;
                margin:auto;
                list-style:none;
            }
            ul li {
                padding: 10px;
            }
            ul li:not(:last-child) {
                border-bottom: 1px solid white;
            }
            a{
                color:inherit;
            }
            ul li a {
                text-decoration: none;
                font-size: 1.3em;
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
                Welcome to my Servlet Assignment
            </h1>
            <p>Follow the links below to view the pages for my assignment. This project is also available on my <a href="https://bbc.co.uk">github.</p>
            <ul>
                <li><a href="./auth.html">Q1: Authorisation</a></li>
                <li><a href="./fileUpload.jsp">Q4: File Upload</a></li>
                <li><a href="./myServletTest">Q2: Servlets and Listeners</a></li>
            </ul>


        </div>

    </body>
    <script
        src="https://kit.fontawesome.com/790277f21c.js"
        crossorigin="anonymous">
    </script>
</html>