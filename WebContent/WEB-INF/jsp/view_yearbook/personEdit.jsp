<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="cancel" value="/actions/person/list" />

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Edit Person.</title>
	</head>
	
	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		<jsp:include page="../view_fragments/navigation.jsp" />
		
		<div id="body_">
			<c:choose>
				<c:when test="${person.id != null}">
					<jsp:include page="../view_fragments/disconnect.jsp" />
					<h3>Modification des données.</h3>
					
					<form:form method="POST" commandName="person">
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
						        <td><form:input path="birthDate" type="date" /></td>
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
							    <td>Groupe : </td>   
							    <td>
							         <form:select path="idG" multiple="false">
							            <form:option value="" label="Choisir un groupe" />
							            <form:options items="${listGroups}" itemValue="id" itemLabel="name"/>
							        </form:select>
							    </td>
							</tr>
						    
					        <tr>
				        		<td><input type="submit" value="Valider"/></td>
				        		<td>
									<button class="btnCancel" onclick="location.href='${cancel}'">Annuler</button>
								</td>
				    		</tr>
						</table>
					</form:form>
				</c:when>
				
				<c:otherwise>
					<jsp:include page="../view_fragments/redirectLogin.jsp" />
			    </c:otherwise>
			</c:choose>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>