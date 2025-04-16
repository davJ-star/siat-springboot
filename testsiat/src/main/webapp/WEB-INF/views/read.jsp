<%@ page 	language="java" 
			contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${read != null}" >
		<form action="../../todo/update" method="post">
			<input type = "text" name = "seq" value = "${read.seq}" readonly> <br/>
			<input type = "text" name = "title" value = "${read.title}" readonly> <br/>
			<input type = "text" name = "content" value = "${read.content}" > <br/>
			<input type = "text" name = "startDate" value = "${read.startDate}" readonly> <br/>
			<input type = "text" name = "status" value = "${read.status}" > <br/>
			<input type = "text" name = "endDate" value = "${read.endDate}" readonly> <br/>
			<input type = "number" name = "priority" value = "${read.priority}" readonly> <br/>
			<input type = "submit" value="수정"> <br/>
			<a href="../../todo/delete?seq=${read.seq}">삭제</a>
			
		</form>
	</c:if>
	<c:if test = "${read == null}" >
		상세정보를 로딩하지 못했습니다...
	</c:if>
</body>
</html>