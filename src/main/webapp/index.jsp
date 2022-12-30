<%@page language="java" pageEncoding="UTF-8" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h2>Register User</h2>

    <a href="list">View Users</a>
    <hr>

    <form action="insert" method="post">
        <div>
            <label class="form-label">Email</label>
            <input class="form-control" type="email" name="email" required />
        </div>
        <div>
            <label class="form-label">First Name</label>
            <input class="form-control" type="text" name="firstName" required />
        </div>
        <div>
            <label class="form-label">Last Name</label>
            <input class="form-control" type="text" name="lastName" required />
        </div>

        <button class="btn btn-success mt-3" type="submit">Submit</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
