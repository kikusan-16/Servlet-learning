<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie session</title>
</head>
<body>

<%
Cookie[] cookies = request.getCookies();
String coo = "";
if (cookies != null) {
    for (Cookie cook : cookies) {
        if (cook.getName().equals("Cookie")) {
            coo = cook.getValue();
        }
    }
}
//HttpSession session = request.getSession();
//dispatchはインスタンス引き継ぐ Aタグかリダイレクトなら必要
String sessionId = (String)session.getAttribute("SessionId");
%>
<p><%= coo %></p>
<p>this is sessionId <%= sessionId %></p>
</body>
</html>