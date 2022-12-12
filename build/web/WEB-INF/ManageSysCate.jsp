<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/ManageSysCateCss.css" rel="stylesheet">
        <title>Manage System Category</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div>
                    <img src="./image/icon.jpg" id="avatar" alt="avatar" style="width: 5rem; height: 5rem;">
                    <a href="admin" class="navbar-brand">Administrator</a>
                </div>
                <a href="login"><button class="btn btn-danger">Logout</button></a>
            </div>
        </nav>
        <div class="container-fluid d-flex justify-content-around align-items-between">
            <div class='col'>
                <h1 class="text-center text-white">Category Dashboard</h1>
                <table class="table table-success table-striped">
                    <thead>
                            <tr>
                                <th>Category</th>
                                <th>Edit</th>
                            </tr>
                    </thead>
                    <tbody>
                            <c:forEach var="category" items="${categories}">
                                <tr>
                                    <td><c:out value="${category.getCategoryName()}"/></td>
                                    <td><a href="managesyscate?action=edit&category=${category.getCategoryId()}"><button type="button" class="btn btn-success">Edit</button></a></td>
                                </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col container-fluid d-flex flex-column justify-content-around align-items-center">
                <div class='row'>
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h3>Add Category</h3>
                            <form action="managesyscate" method="POST">
                                <input type="hidden" name="action" value="add">
                                <div class="mb-3">
                                    <label for="category" class="form-label">Category:</label>
                                    <input type="text" name="category" class="form-control" id="category" required>
                                </div>
                                <button type="submit" class="btn btn-primary">Save</button> 
                            </form>
                        </div>
                    </div>
                </div>
                <div class='row'>
                    <c:if test="${editEnable != null}">
                        <div class="card" style="width: 18rem;">
                            <div class="card-body">
                                <h3>Edit Category</h3>
                                <form action="managesyscate" method="post">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="id" class="form-control" id="id" value="${editCategory.getCategoryId()}" required>
                                    <div class="mb-3">
                                        <label for="category" class="form-label">Category:</label>
                                        <input type="text" name="category" class="form-control" id="category" value="${editCategory.getCategoryName()}" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Save</button>       
                                    <a href="managesyscate?action=cancel" class="btn btn-primary bg-light text-dark">Cancel</a>
                                </form> 
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
