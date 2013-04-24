<%@ include file="/WEB-INF/jsp/header.jsp" %>

<spring:url value="/" var="homeUrl" />
<spring:url var="addUrl" value="/question/new"/>

<div class="bs-docs-example" data-content="<spring:message code="Questions"></spring:message>">
	<aripd:datatables datasource="/question/get" id="questions" dataUrlShow="/question/show">
		<aripd:column label="Action" field="id"/>
		<aripd:column label="Username" field="account.username"/>
		<aripd:column label="Date" field="createdAt"/>
		<aripd:column label="Subject" field="subject"/>
		<aripd:column label="Status" field="active"/>
		<aripd:column label="Urgency" field="urgency"/>
	</aripd:datatables>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>