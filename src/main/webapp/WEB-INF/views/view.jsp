<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<table class="table-active" border="2" width="70%" cellpadding="2">
		<tr>
			<th class="table-success">Hotel NAME</th>
			<th class="table-primary">Average Rating</th>


		</tr>
		<c:forEach var="hotel" items="${hotel}">
			<tr class="info">
				<td>${hotel.hotelName}</td>
				<td>${hotel.averageRating}</td>

			</tr>

		</c:forEach>
	</table>

	<a href="/">
		<button>back</button>
	</a>
</body>
</html>