<%@ include file="/WEB-INF/jsp_files/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editPwd" value="/actions/person/forgotPwd" />
<c:url var="editRegister" value="/actions/person/register" />

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/WEB-INF/css_files/yearbook.css" />
		<title>Login</title>
	</head>
	
	<body class="login">
		<h3>Identifiez-vous pour accéder à l'annuaire.</h3>
		
		<form:form method="POST" commandName="person">
			<form:errors path="*" cssClass="errorblock" element="div"/>
			<table>
				<c:if test="${person.id == null && person.email != null && person.pwd != null}">
			   		<p>Login ou mot de passe incorrect.</p>
				</c:if>
				<tr>
			    	<td>Login : </td>
			        <td><form:input path="email" /></td>
			    </tr>

			    <tr>
			        <td>Mot de passe : </td>
			        <td><form:input path="pwd" type="password"/></td>
			    </tr>
			    
			    <tr>
			        <td><input type="submit" value="Connexion"/></td>
			    </tr>
		    </table>
		    <p class="pwd"><a href="${editPwd}">Mot de passe oublié.</a></p>
		    <p class="register">Vous n’avez pas de compte? <a href="${editRegister}">Inscription</a></p>
		</form:form>
	</body>
</html>