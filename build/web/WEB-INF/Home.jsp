<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/HomeCss.css" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>
        <h1 class="text-center text-white">Hello ${user.getFirstName()}</h1>
        <div class="container-fluid d-flex justify-content-between align-items-center">
            <div class="card" style="width: 18rem; height: 100vh;">
                <img src="./image/icon.jpg" class="card-img-top" id="avatar" alt="avatar">
                <div class="card-body">
                    <h5 class="card-title">Email: </h5>
                    <div class="card-text"><c:out value="${user.getEmail()}"/></div>
                    <h5 class="card-title">First Name: </h5>
                    <div class="card-text"><c:out value="${user.getFirstName()}"/></div>
                    <h5 class="card-title">Last Name: </h5>
                    <div class="card-text"><c:out value="${user.getLastName()}"/></div>
                    <h5 class="card-title">Password: </h5>
                    <div class="card-text"><c:out value="${user.getPassword()}"/></div>
                    <h5 class="card-title">Role: </h5>
                    <div class="card-text"><c:out value="${user.getRole().getRoleName()}"/></div>
                    <div><a href="home?action=unactive"><button type="button" class="btn btn-danger">De-activated</button></a></div>
                    <a href="inventory"><button type="button" class="btn btn-info mt-3">Go to Inventory</button></a>
                </div>   
            </div>  
            <div class="card" style="width: 70rem; height: 100vh;">
                <h2>Edit Information</h2>
                <div class="card-body">
                    <form action="home" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email:</label>
                            <input readonly="readonly" type="text" name="email" class="form-control" id="email" value="${user.getEmail()}">
                        </div>
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name:</label>
                            <input type="text" name="firstName" class="form-control" id="firstName" value="${user.getFirstName()}">
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name:</label>
                            <input type="text" name="lastName" class="form-control" id="lastName" value="${user.getLastName()}">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password:</label>
                            <input type="text" name="password" class="form-control" id="password" value="${user.getPassword()}">
                        </div>
                        <div class="mb-3">
                            <label for="role" class="form-label">Role: </label>
                            <input readonly="readonly" type="text" name="role" class="form-control" id="role" value="${user.getRole().getRoleName()}">
                        </div>
                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
                </div>  
            </div>
        </div>
    </body>
</html>
