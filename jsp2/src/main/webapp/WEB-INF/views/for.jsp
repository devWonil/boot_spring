<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<header>
		<h1>For loop Example</h1>
	</header>
	<main>
		1에서 10까지 합은?
		<!-- JSP 태그를 활용해서 1 + 2 + 3 + 4 +... = 55 -->
		<br/>
		<%	int sum = 0;
			for(int i = 1; i < 11; i++){%>
				
			<b><%=sum += i%></b>
			<br/>
			<%
			}
		%>
	</main>
</body>
</html>