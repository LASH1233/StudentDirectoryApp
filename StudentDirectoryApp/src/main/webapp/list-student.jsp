<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Directory</title>
</head>
<body>
    <h2>Student Directory</h2>

    <a href="add-student.jsp">Add Student</a>
    <br><br>

    <c:if test="${not empty studentList}">
        <table border="1">
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Course</th>
            </tr>
            <c:forEach var="s" items="${studentList}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.course}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty studentList}">
        <p>No students found.</p>
    </c:if>
</body>
</html>
