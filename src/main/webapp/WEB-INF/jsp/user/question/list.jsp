<%@ include file="/WEB-INF/jsp/header.jsp" %>

<spring:url value="/" var="homeUrl" />
<spring:url var="addUrl" value="/user/question/new"/>

<a class="btn btn-success btn-large btn-block" href="${addUrl}"><spring:message code="New Entry"></spring:message></a>

<div class="bs-docs-example" data-content="<spring:message code="Questions"></spring:message>">
	<aripd:datatables datasource="/user/question/get" id="questions" dataUrlShow="/user/question/show" dataUrlEdit="/user/question/edit">
		<aripd:column label="Action" field="id"/>
		<aripd:column label="Date" field="createdAt"/>
		<aripd:column label="Subject" field="subject"/>
		<aripd:column label="Status" field="active"/>
		<aripd:column label="Urgency" field="urgency"/>
	</aripd:datatables>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>