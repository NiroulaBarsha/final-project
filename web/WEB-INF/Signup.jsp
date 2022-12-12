<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/SignupCss.css" rel="stylesheet">
        <title>Sign Up</title>
    </head>
    <body class="d-flex flex-column justify-content-around align-items-center">
        <h1 class="text-white mb-5">Sign Up</h1>
        <div class="text-danger">${message}</div>
        <div class="card" style="width: 25rem;">
            <div class="card-body">
                <form action="signup" method="POST">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email: </label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password: </label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <div class="mb-3">
                        <label for="firstName" class="form-label">First Name: </label>
                        <input type="text" class="form-control" id="firstName" name="firstName" required>
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="form-label">Last Name: </label>
                        <input type="text" class="form-control" id="lastName" name="lastName" required>
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type="submit" class="btn btn-success">Sign Up</button>
                        <a href="login"><button type="button" class="btn btn-primary">Back to login</button></a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
