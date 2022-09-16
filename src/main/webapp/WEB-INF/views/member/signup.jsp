<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Header -->
    <%@include file="../include/header.jsp" %>
    <!-- Header End -->
</head>
<body>
	<script>
		$(function(){
			opener.parent.connectIFrame('${userInfo}');
			window.open('','_self').close();
		});
	</script>
</body>
</html>