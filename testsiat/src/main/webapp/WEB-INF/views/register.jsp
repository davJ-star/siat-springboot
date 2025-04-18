<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../valid/insert" method="post">
		<input type="text" name="title">
		${validation.title}
		<input type="text" name="content"><br/>
		${validation.content}
		<input type="number" name="priority"><br/>
		${validation.priority}
		<input type="text" name="phone"><br/>
		${validation.phone}
		<input type="submit" name="작성하기">
	</form>
</body>
</html>