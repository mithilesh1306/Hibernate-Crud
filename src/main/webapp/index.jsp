<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Welcome Back!!</h1>

    <div class="card p-4 shadow-sm">
        <form action="insert" method="post">
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <input type="text" name="name" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Age:</label>
                <input type="number" name="age" class="form-control">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

        <hr class="my-4">

        <form action="view" method="post">
            <button class="btn btn-secondary">View</button>
        </form>
    </div>
</div>

</body>
</html>
