<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投票画面</title>
</head>
<body>
<h1>投票してください</h1>
<div style="width: 100px; height: 100px; background-color: ${randomColor};"></div>
<form action="vote" method="post">
    <input type="radio" name="color" value="red"> 赤<br>
    <input type="radio" name="color" value="blue"> 青<br>
    <input type="radio" name="color" value="yellow"> 黄<br>
    <input type="submit" value="投票">
</form>
</body>
</html>