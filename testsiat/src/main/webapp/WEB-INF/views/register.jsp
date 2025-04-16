<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../todo/insert" method="post">
		<input type="text" name="title">
		<input type="text" name="content">
		<input type="number" name="priority" min = "1" max = "10">
		<input type="submit" name="작성하기">
	</form>
</body>
</html>