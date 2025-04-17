<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <div align = "center">
            섭섭이와 함께하는 도파민 터트리는 TodoWEB
      </div>
      <div align = "right">
         <c:if test="${ UserSession == null }">
            <form action="./user/login" method = "post">
                  아이디 :    <input type = "text"        name = "id"    placeholder = "아이디 입력">
                  비밀번호 :    <input type = "password"    name = "pwd"    placeholder = "패스워드 입니다.">              
                  <input type = "submit"  value = "로그인">
            </form>
         </c:if>
         <c:if test="${ UserSession != null }">
               ${ UserSession.name } 님 환영합니다.
               <a href = "./logout.todo">로그아웃</a>
         </c:if>

      </div>
      <ul>
            <li><a href = "./todo/registerForm" >Todo 등록하기</a></li>
            <li><a href = "./todo/select" >Todo 목록보기</a></li>
        </ul>
       
</body>
</html>