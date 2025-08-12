<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.model.StudentInfo" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">Student List</h2>

<%
  List<StudentInfo> user = (List<StudentInfo>) request.getAttribute("User");
  if (user != null && !user.isEmpty()) {
%>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
<%
    for(StudentInfo s : user) {
%>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>
                <td>
                    <a href="delete?id=<%=s.getId()%>" class="btn btn-danger btn-sm">Delete</a>
                    <a href="edit?id=<%= s.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                </td>
            </tr>
<%
    }
%>
        </tbody>
    </table>

<%
  } else {
%>
    <div class="alert alert-info text-center">No student records found.</div>
<%
  }
%>

</div>

</body>
</html>
