<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
<%
//データ取得
String gameName = request.getParameter("Game");
String hardName = request.getParameter("Hard");
Integer count = (Integer)request.getAttribute("Count");
%>
<html>
<head>
<title>あなたの回答</title>
</head>
<body>
<h1>あなたの回答</h1>
好きなゲームは<%= gameName %>です。<br>
初めて購入したハードは<%= hardName %>です。<br>
購入したハードの個数は<%= count %>です。

</body>
</html>

</body>
</html>