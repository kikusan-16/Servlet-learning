<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is jsp</title>
</head>
<body>
<!%-- JSPのコメント --%>
<%
    String str = new String("HelloWorld!");

    for(int i=0; i<5; i++){
%>
        <p><%= str %><%= i %></p>
<%
    }
%>

	<h1>サーブレットへのGETデータ送信</h1>
	<form action="Controller" method="GET">
	<p>好きなゲームは？</p>
	<input type="TEXT" name="Game" size=40>
	<p>購入したハードは？</p>
	<input type="checkbox" name="Hard" value="ファミコン">ファミコン<br />
	<input type="checkbox" name="Hard" value="スーパーファミコン">スーパーファミコン<br />
	<input type="checkbox" name="Hard" value="セガサターン">セガサターン<br />
	<input type="checkbox" name="Hard" value="プレーステーション">プレイステーション<br /><br />
	<input type="submit" value="GET">
	</form>

    <h1>サーブレットへのPOSTデータ送信</h1>
    <form action="Controller" method="POST">
    <p>あなたの名前は？</p>
    <input type="TEXT" name="name" size=40>
    <input type="submit" value="POST">
    </form>
</body>
</html>