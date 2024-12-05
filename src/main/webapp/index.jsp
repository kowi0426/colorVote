<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ColorVote</title>
</head>
<body>
    <h1>ランダムな色を投票してください</h1>
    <div style="width: 100px; height: 100px; background-color: ${randomColor};"></div>
    <a href="ColorVoteServlet">投票を始める</a>
</body>
</html>