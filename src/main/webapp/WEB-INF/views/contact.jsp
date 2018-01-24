<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Contact Us</title>
</head>
<body>
	<h3>Contact Us</h3>
	<div class="contatiner">
		<form:form method="post" modelAttribute="contactForm"
			class="form-group"
			action="sendEmail">
			<table>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:input type="text" path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name:</form:label></td>
					<td><form:input type="text" path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="email">E-mail:</form:label></td>
					<td><form:input type="text" path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<%-- <td><form:input name="join"
							path="joinMailingList" /></td>--%>
					<td><form:checkbox path="joinMailingList" /> <form:label
							path="joinMailingList">Join the mailing list</form:label></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit Form" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>