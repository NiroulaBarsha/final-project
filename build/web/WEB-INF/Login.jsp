<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/LoginCss.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body class="d-flex flex-column justify-content-around align-items-center">
        <h1 class="text-center">Home nVentory</h1>
        <div class="card" style="width: 25rem;">
            <div class="card-body">
            <form action="login" method="POST">
            <div class="container-fluid align-items-center">
                <div class="mb-3">
                    <label for="email" class="form-label">Email: </label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
                </div>
                <div class="mb-3">
                    <label for="password" class="col col-form-label">Password: </label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
                <div class="text-danger">${message}</div>
            </div>
            </form>
            </div>
        </div>
        <div>
            <a href="signup"><button class="btn btn-success" style="width: 25rem;">Sign Up</button></a>
        </div>
    </body>
</html>
