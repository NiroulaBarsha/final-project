<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/InventoryCss.css" rel="stylesheet">
        <title>Inventory</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div>
                    <img src="./image/icon.jpg" id="avatar" alt="avatar" style="width: 5rem; height: 5rem;">
                    <a class="navbar-brand" href="home">${name}</a>
                </div>
                <a href="login"><button class="btn btn-danger">Logout</button></a>
            </div>
        </nav>
        <div class="container-fluid d-flex justify-content-around align-items-center row"> 
            <div class="col">
                <h2 class="text-center text-white">Your Inventory</h2>
                <div class="text-center text-danger">${message}</div>
                <table class="table table-info table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Price</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${items}">
                                <tr>
                                    <td><c:out value="${item.getItemName()}"/></td>
                                    <td><c:out value="${item.getCategory().getCategoryName()}"/></td>
                                    <td><c:out value="${item.getPrice()}"/></td>
                                    <td><a href="inventory?action=edit&item=${item.getItemId()}"><button type="button" class="btn btn-success">Edit</button></a></td>
                                    <td><a href="inventory?action=delete&item=${item.getItemId()}"><button type="button" class="btn btn-danger">Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                </table>
            </div>
            <div class="col">
                <div class="card mt-4" style="width: 45rem;">
                    <div class="card-body">
                        <h3>Add Item</h3>
                        <form action="inventory" method="POST">
                            <input type="hidden" name="action" value="add">
                            <div class="mb-3">
                                <label for="category" class="form-label">Category: </label>
                                <select name="category" id="category" class="form-select" required>
                                    <option selected>Select a category</option>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="name" class="form-label">Name: </label>
                                <input type="text" name="name" class="form-control" id="name" required>
                            </div>
                            <div class="mb-3">
                                <label for="price" class="form-label">Price: </label>
                                <input type="number" step='any' name="price" class="form-control" id="price" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Save</button> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
            <c:if test="${editEnable != null}">
                <div class="row">
                    <div class="card" style="width: 100vw;">
                        <div class="card-body">
                            <h1>Edit Item</h1>
                            <form action="inventory" method="post">
                                <input type="hidden" name="action" value="update">
                                <div class="mb-3">
                                    <label for="id" class="form-label">Item ID:</label>
                                    <input readonly="readonly" type="text" name="id" class="form-control" id="id" value="${editItem.getItemId()}">
                                </div>
                                <div class="mb-3">
                                    <label for="category" class="form-label">Category</label>
                                    <select name="category" id="category" class="form-select">
                                        <option selected value='${editItem.getCategory().getCategoryId()}'>Current: ${editItem.getCategory().getCategoryName()}</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name</label>
                                    <input type="text" name="name" class="form-control" id="name" value="${editItem.getItemName()}">
                                </div>
                                <div class="mb-3">
                                    <label for="price" class="form-label">Price</label>
                                    <input type="number" step='any' name="price" class="form-control" id="price" value="${editItem.getPrice()}">
                                </div>
                                <button type="submit" class="btn btn-secondary">Save</button>       
                                <a href="inventory?action=cancel" class="btn btn-primary bg-light text-dark">Cancel</a>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>
    </body>
</html>
