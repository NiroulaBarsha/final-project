<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="style/ManageSysUserCss.css" rel="stylesheet">
        <title>Manage System User</title>
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
            <div class="row container-fluid">
                <h2 class="text-center text-white">Account Dashboard</h2>
                <table class="table table-success table-striped">
                        <thead>
                            <tr>
                                <th>Email</th>
                                <th>Active</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Password</th>
                                <th>Role</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td><c:out value="${user.getEmail()}"/></td>
                                    <td><c:out value="${user.getActive() ? 'active' : 'unactive'}"/></td>
                                    <td><c:out value="${user.getFirstName()}"/></td>
                                    <td><c:out value="${user.getLastName()}"/></td>
                                    <td><c:out value="${user.getPassword()}"/></td>
                                    <td><c:out value="${user.getRole().getRoleName()}"/></td>
                                    <td><a href="managesysuser?action=edit&user=${user.getEmail()}"><button type="button" class="btn btn-success">Edit</button></a></td>
                                    <td><a href="managesysuser?action=delete&user=${user.getEmail()}"><button type="button" class="btn btn-danger">Delete</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                </table>
            </div>
        <div class="container-fluid d-flex justify-content-around align-items-center row">
            <div class="col">
                <div class="card" style="width: 40rem;">
                    <div class="card-body">
                        <h3>Add Account</h3>
                        <form action="managesysuser" method="POST">
                                <input type="hidden" name="action" value="add">
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email:</label>
                                    <input type="text" name="email" class="form-control" id="email" required>
                                </div>
                                <div class="mb-3">
                                    <div class="form-check">
                                        <label class="form-check-label" for="active">Active</label>
                                        <input class="form-check-input" type="checkbox" value="1" id="active" name="active">
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" name="firstName" class="form-control" id="firstName" required>
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" name="lastName" class="form-control" id="lastName" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="text" name="password" class="form-control" id="password" required>
                                </div>
                                <div class="mb-3">
                                    <label for="role" class="form-label">Role</label>
                                    <select name="role" id="role" class="form-select">
                                        <option selected>Select a role</option>
                                        <c:forEach var="role" items="${roles}">
                                            <option value="${role.getRoleId()}">${role.getRoleName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Save</button> 
                        </form>
                    </div>
                </div>
            </div>
            <c:if test="${editEnable != null}">
                <div class="col">
                    <div class="card" style="width: 40rem;">
                        <div class="card-body">
                            <h3>Edit Account</h3>
                            <form action="managesysuser" method="post">
                                <input type="hidden" name="action" value="update">
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email:</label>
                                    <input readonly="readonly" type="text" name="email" class="form-control" id="email" value="${editUser.getEmail()}" required>
                                </div>
                                <div class="mb-3">
                                    <div class="form-check">
                                        <label class="form-check-label" for="active">Active</label>
                                        <input class="form-check-input" type="checkbox" value="1" id="active" name="active" ${editUser.getActive() ? 'checked' : ''}>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" name="firstName" class="form-control" id="firstName" value="${editUser.getFirstName()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" name="lastName" class="form-control" id="lastName" value="${editUser.getLastName()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="text" name="password" class="form-control" id="password" value="${editUser.getPassword()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="role" class="form-label">Role</label>
                                    <select name="role" id="role" class="form-select">
                                        <option selected value='${editUser.getRole().getRoleId()}'>Current: ${editUser.getRole().getRoleName()}</option>
                                        <c:forEach var="role" items="${roles}">
                                            <option value="${role.getRoleId()}">${role.getRoleName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Save</button>       
                                <a href="managesysuser?action=cancel" class="btn btn-primary bg-light text-dark">Cancel</a>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
