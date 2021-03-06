<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="forgotPwd" value="/actions/person/forgotPwd" />
<c:url var="editRegister" value="/actions/person/register" />

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Login</title>
	</head>
	
	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		
		<div id="body_">
			<c:choose>
				<c:when test="${person.id == null}">
					<h3>Identifiez-vous pour accéder à l'annuaire.</h3>
					
					<form:form method="POST" commandName="person">
						<form:errors path="*" cssClass="errorblock" element="div"/>
						
						<c:if test="${pwdSend != false && person.pwd == null}">
							<p id="pwdSend">
								Un nouveau mot de passe vient de vous être envoyé à l'adresse que vous avez indiqué!
							</p>
						</c:if>
						
						<c:if test="${person != null && person.email != null}">
							<p id="logError">
								Login ou mot de passe incorrect!
							</p>
						</c:if>
						
						<table>
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
						    
						    <tr id="pwd_register">
						    	<td><a href="${forgotPwd}">Mot de passe oublié</a></td>
						    	<td><a href="${editRegister}">Inscription</a></td>
						    </tr>
					    </table>
					</form:form>
				</c:when>
				
				<c:otherwise>
					<c:redirect url="/actions/person/list" />
			    </c:otherwise>
			</c:choose>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>