<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录注册系统首页</title>


</head>

<body>
	<h1>首页</h1>
	<hr>
	<%
		String user = (String) session.getAttribute("userName");
	%>
	<%
		if (user == null) {
	%>
	欢迎游客光临！
	<a href="${pageContext.request.contextPath}/Login.jsp">登录</a>
	<a href="${pageContext.request.contextPath}/Register.jsp">注册</a>
	<%
		} else {
	%>
	欢迎回来!<%=user%>
	<a href="${pageContext.request.contextPath}/servlet/Logout">注销</a>
	<%
		}
	%>
</body>
</html>
