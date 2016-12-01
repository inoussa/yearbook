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
		<title>Register Person.</title>
	</head>
	
	<body>
		<h3>Inscription dans l'annuaire.</h3>
		
		<form:form method="POST" commandName="person">
			<form:errors path="*" cssClass="errorblock" element="div"/>
			<table>
				<tr>
			    	<td>Nom : </td>
			        <td><form:input path="lastName"/></td>
			    </tr>
			    
			    <tr>
			    	<td>Prénom : </td>
			        <td><form:input path="firstName"/></td>
			    </tr>
			    
			    <tr>
			        <td>Date de naissance : </td>
			        <td><form:input path="birthDate" type="date"/></td>
			    </tr>
			    
			    <tr>
			        <td>Page web : </td>
			        <td><form:input path="homePage" type="url" /></td>
			    </tr>
			    
			    <tr>
			        <td>Email : </td>
			        <td><form:input path="email" /></td>
			    </tr>

			    <tr>
			        <td>Mot de passe : </td>
			        <td><form:input path="pwd" type="password"/></td>
			    </tr>
			    
			    <tr>
			        <td><input type="submit" value="Envoyer"/></td>
			    </tr>
		    </table>
		</form:form>
	</body>
</html>