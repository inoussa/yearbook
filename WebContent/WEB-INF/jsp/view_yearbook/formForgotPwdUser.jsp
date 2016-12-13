<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="redirectDisconnect" value="/actions/person/disconnect" />
<c:url var="redirectList" value="/actions/person/list" />
<c:url var="redirectLogin" value="/actions/person/login" />

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
			<c:choose>
				<c:when test="${person.id == null}">
					<h3>Entrez votre email.</h3>
					
					<form:form method="POST" commandName="person">
						<form:errors path="*" cssClass="errorblock" element="div"/>
						<table>
							<tr>
						    	<td>Email : </td>
						        <td><form:input path="email" /></td>
						    </tr>
			
							<tr>
						        <td><input type="submit" value="Envoyer"/></td>
						    </tr>
					    </table>
					    <p class="lien_acceuil"><a href="${redirectLogin}">Acceuil.</a></p>
					</form:form>
				</c:when>
				
				<c:otherwise>
					<p>
						Vous êtes déjà connecté.<br/>
						Pour accéder à cette page, déconnectez-vous en cliquant <a href="${redirectDisconnect}">ici.</a><br/>
						Pour retourner à l'acceuil, cliquer <a href="${redirectList}">ici.</a>
					</p>
			    </c:otherwise>
			</c:choose>
		</div>	
	</body>
</html>