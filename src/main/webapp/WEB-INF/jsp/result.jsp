<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>投票結果</title>
</head>
<body>
    <h1>投票結果</h1>
    <table border="1">
        <tr>
            <th>色</th>
            <th>赤</th>
            <th>青</th>
            <th>黄</th>
        </tr>
        <c:forEach var="entry" items="${allVotes}">
            <tr>
                <td style="background-color: ${entry.key}; width: 100px;">&nbsp;</td>
                <td>${entry.value.red}</td>
                <td>${entry.value.blue}</td>
                <td>${entry.value.yellow}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="ColorVoteServlet">新しい色に投票</a>
</body>
</html>