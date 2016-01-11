<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>


</head>

<body>
	<form action="${pageContext.request.contextPath}/servlet/Register"
		method="post" onsubmit="return check(this)">
		新账户：<input type="text" name="user" width="60px" /> <br>新密码：<input
			type="password" name="pwd" width="60px" /> <br> <input
			type="submit" value="提交" />
	</form>

</body>
<script type="text/javascript">
	function check(form) {
		var userName = form.user;
		var userPwd = form.pwd;
		if (userName.value.length < 4 || userPwd.value.length < 4) {
			alert('用户名或密码不合法！');
			return false;
		}
		return true;
	}
</script>
</html>
