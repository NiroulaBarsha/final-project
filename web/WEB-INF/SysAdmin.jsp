<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/SysAdminCss.css" rel="stylesheet">
        <title>System Administrator</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div>
                    <img src="./image/icon.jpg" id="avatar" alt="avatar" style="width: 5rem; height: 5rem;">
                    <span class="navbar-brand">Administrator</span>
                </div>
                <a href="login"><button class="btn btn-danger">Logout</button></a>
            </div>
        </nav>
        <h1 class="text-center text-white">Welcome, Admin</h1>
        <div class="d-flex justify-content-around align-items-center">
            <div class="card mt-4" style="width:18rem; height: 30rem">
                <img src="./image/user.jpg" class="card-img-top" alt="User Manage" style="width: 18rem; height: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Manage User</h5>
                    <p class="card-text">Managing user accounts of Home nVentory</p>
                    <a href="managesysuser">
                        <button type="button" class="btn btn-info">Access</button>
                    </a>
                </div>
            </div>
            <div class="card mt-4" style="width: 18rem; height: 30rem">
                <img src="./image/category.jpg" class="card-img-top" alt="Category Manage" style="width: 18rem; height: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Manage Category</h5>
                    <p class="card-text">Managing user accounts of Home nVentory</p>
                    <a href="managesyscate">
                        <button type="button" class="btn btn-info">Access</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
