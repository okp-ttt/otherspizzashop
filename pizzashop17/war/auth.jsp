<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
</head>
<body>
	<%@ page import="com.google.appengine.api.users.*" pageEncoding="utf-8"
		contentType="text/html;charset=utf-8"%>
	<%
UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();
String msg;

if( user != null ){

  msg = "ようこそ! あなたは <b>" + user.getNickname() + "</b> という名前でログインしています。"
    + " <a href='" + userService.createLogoutURL("/") + "'>サインアウト</a>"
	+ "<br>"+ " <a href='checkOrder.html'>店員用ページへ</a>";
}
else {

  msg = "こんにちは! こちらから "
    + "<a href='" + userService.createLoginURL("checkOrder.html") + "'>サインイン</a> してください!";
}

System.out.println( msg );
%>
	<p class="round"><%= msg %></p>

</body>
</html>