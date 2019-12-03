<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="header" class="wrap">
		<jsp:include page="common/top.jsp" />
	</div>
	<div id="main" class="wrap">
		<jsp:include page="${mainPage}"/>
		<div class="clear"></div>
	</div>
	<div id="footer">
		<jsp:include page="common/footer.jsp" />
	</div>
</body>
</html>