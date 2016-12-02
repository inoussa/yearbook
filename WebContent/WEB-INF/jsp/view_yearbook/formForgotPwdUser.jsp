<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Forgot password</title>
	</head>
	<body>
		<div id="body_">
			<h3>Entrez votre email.</h3>
			
			<form:form method="POST" commandName="person">
				<form:errors path="*" cssClass="errorblock" element="div"/>
				<table>
					<c:if test="${person == null}">
				   		<p>Login incorrect.</p>
					</c:if>
					<tr>
				    	<td>Email : </td>
				        <td><form:input path="email" /></td>
				    </tr>
	
					<tr>
				        <td><input type="submit" value="Envoyer"/></td>
				    </tr>
			    </table>
			</form:form>
		</div>	
	</body>
</html>