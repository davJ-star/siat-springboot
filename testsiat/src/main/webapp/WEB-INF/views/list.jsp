<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- public class List {}와 동일하다. -->
	<%!
		private String name;
	%>
	
	
	
	<table class="table">
    <thead>
      <tr>
        <th>Title</th>
        <th>Status</th>
        <th>Priority</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="dto">
	      <tr>
	        <%-- <td><a href="./view/${dto.seq}">${dto.title}</a></td> --%>
			<td><a href="read?seq=${dto.seq}">${dto.title}</a></td>
	        <td>${dto.status}</td>
	        <td>${dto.priority}</td>
	      </tr>
      	</c:forEach>
    </tbody>
  </table>
	
	<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>