<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.StudentInfo" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <%
        StudentInfo student = (StudentInfo) request.getAttribute("student");
        if (student != null) {
    %>
        <div class="card shadow p-4">
            <h2 class="mb-4">Edit Student</h2>
            <form action="update" method="post">
                <input type="hidden" name="id" value="<%= student.getId() %>" />
                
                <div class="mb-3">
                    <label class="form-label">Name:</label>
                    <input type="text" name="name" class="form-control" value="<%= student.getName() %>" />
                </div>

                <div class="mb-3">
                    <label class="form-label">Age:</label>
                    <input type="number" name="age" class="form-control" value="<%= student.getAge() %>" />
                </div>

                <input type="submit" class="btn btn-success" value="Update" />
            </form>
        </div>
    <%
        } else {
    %>
        <div class="alert alert-warning text-center">Student not found.</div>
    <%
        }
    %>
</div>

</body>
</html>
