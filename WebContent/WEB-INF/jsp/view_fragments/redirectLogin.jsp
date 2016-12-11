<%@ include file="/WEB-INF/jsp/jstlPrefix.jsp" %>

<c:url var="redirectLogin" value="/actions/person/login" />

<div id="loginRedirect_">
	<p>
		Merci de vous connecter pour accéder à cette page.<br/>
		Pour vous logger, cliquer <a href="${redirectLogin}">ICI.</a>
	</p>
</div>