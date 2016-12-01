<%@ include file="/WEB-INF/jsp_files/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/WEB-INF/css_files/yearbook.css" />
		<title>Forgot password</title>
	</head>
	<body class="reminderPwd">
		<h3>Entrez votre email.</h3>
		
		<form:form method="POST" commandName="person">
			<form:errors path="*" cssClass="errorblock" element="div"/>
			<table>
				<c:if test="${person eq null}">
			   		<p>Email incorrect.</p>
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
	</body>
</html>