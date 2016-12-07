<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/yearbook.css" />" />
		<title>Home</title>
	</head>

	<body>
		<jsp:include page="../view_fragments/header.jsp" />
		<jsp:include page="../view_fragments/navigation.jsp" />
		
		<div id="body_">
			<h2>Acceuil.</h2>
		    <p>Ce travail consiste à réaliser une application de gestion d'un annuaire de personnes.<br/>
		    Le travail sera fait en utilisant la technologie JEE.<br/>Il est à réaliser en groupe de 2.<br/>
		    </p>
		</div>
		
		<jsp:include page="../view_fragments/footer.jsp" />
	</body>
</html>