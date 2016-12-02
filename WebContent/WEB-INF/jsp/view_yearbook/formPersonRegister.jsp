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
		<title>Register Person.</title>
	</head>
	
	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		
		<div id="body_">
			<h3>Inscription dans l'annuaire.</h3>
			
			<form:form method="POST" commandName="person">
				<form:errors path="*" cssClass="errorblock" element="div"/>
				<table>
					<tr>
				    	<td>Nom : </td>
				        <td><form:input path="lastName"/></td>
				        <td><form:errors path="lastName" cssClass="error" /></td>
				    </tr>
				    
				    <tr>
				    	<td>Prénom : </td>
				        <td><form:input path="firstName"/></td>
				        <td><form:errors path="firstName" cssClass="error" /></td>
				    </tr>
				    
				    <tr>
				        <td>Date de naissance : </td>
				        <td><form:input path="birthDate" type="date" /></td>
				        <td><form:errors path="birthDate" cssClass="error" /></td>
				    </tr>
				    
				    <tr>
				        <td>Page web : </td>
				        <td><form:input path="homePage" type="url" /></td>
				        <td><form:errors path="homePage" cssClass="error" /></td>
				    </tr>
				    
				    <tr>
				        <td>Email : </td>
				        <td><form:input path="email" /></td>
				        <td><form:errors path="email" cssClass="error" /></td>
				    </tr>
	
				    <tr>
				        <td>Mot de passe : </td>
				        <td><form:input path="pwd" type="password"/></td>
				        <td><form:errors path="pwd" cssClass="error" /></td>
				    </tr>
				    
				    <tr>
					    <td>Groupe : </td>
					    <td>
					        <form:select path="" multiple="false">
					            <form:option value="" label="----- Select -----" />
					            <form:options items="${allGroups}" />
					        </form:select>
					    </td>
					</tr>
				    
				    <tr>
				        <td><input type="submit" value="Envoyer"/></td>
				    </tr>
			    </table>
			</form:form>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>
