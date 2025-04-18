<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Khai báo JSTL và Spring Form Tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <!-- Link đến Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card" style="width: 100%; max-width: 400px;">
        <div class="card-body">
            <h2 class="card-title text-center">Create Account</h2>

            <!-- Sửa lại thẻ form và input -->
            <form:form action="signupAction" method="post" modelAttribute="user">
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <form:input path="username" id="username" class="form-control" required="true" />
                </div>

                <div class="form-group">
                    <label for="password">Mật khẩu:</label>
                    <form:input path="password" type="password" id="password" class="form-control" required="true" />
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Nhập lại mật khẩu:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required="true" />
                </div>

                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">Đăng ký</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


    <!-- Link đến Bootstrap JS và Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>


</body>
</html>
