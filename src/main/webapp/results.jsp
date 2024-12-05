<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%
    Map<String, Integer> voteCounts = (Map<String, Integer>) application.getAttribute("voteCounts");
    if (voteCounts == null) {
        voteCounts = new HashMap<>();
        voteCounts.put("red", 0);
        voteCounts.put("blue", 0);
        voteCounts.put("yellow", 0);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投票結果</title>
<style>
    .bar { width: 100px; height: 20px; margin: 5px; }
    .red { background-color: red; }
    .blue { background-color: blue; }
    .yellow { background-color: yellow; }
</style>
</head>
<body>
<h1>投票結果</h1>
<p>赤: <span class="bar red" style="width:<%= voteCounts.get("red") * 10 %>px;"></span> <%= voteCounts.get("red") %></p>
<p>青: <span class="bar blue" style="width:<%= voteCounts.get("blue") * 10 %>px;"></span> <%= voteCounts.get("blue") %></p>
<p>黄: <span class="bar yellow" style="width:<%= voteCounts.get("yellow") * 10 %>px;"></span> <%= voteCounts.get("yellow") %></p>
<a href="index.jsp">戻る</a>
</body>
</html>