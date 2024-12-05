<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>投票画面</title>
</head>
<body>
    <h1>ランダムな色に投票してください</h1>
    
    <!-- 色の表示 -->
    <c:if test="${not empty sessionScope.currentColor}">
        <div style="width: 100px; height: 100px; background-color: ${sessionScope.currentColor};">
        </div>
    </c:if>

    <form action="ColorVoteServlet" method="post">
        <label>
            <input type="radio" name="color" value="red"> 赤
        </label>
        <label>
            <input type="radio" name="color" value="blue"> 青
        </label>
        <label>
            <input type="radio" name="color" value="yellow"> 黄
        </label>
        <button type="submit">投票</button>
    </form>
</body>
</html>