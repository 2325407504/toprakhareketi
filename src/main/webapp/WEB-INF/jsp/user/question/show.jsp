<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="bs-docs-example" data-content="<spring:message code="Questions"></spring:message>">

	<spring:url var="question_status" value="/user/question/status/${questionAttribute.id}" />
	<c:if test="${questionAttribute.active}">
	<a class="pull-right btn" href="${question_status}"><spring:message code="Close"></spring:message></a>
	</c:if>
	<c:if test="${!questionAttribute.active}">
	<a class="pull-right btn" href="${question_status}"><spring:message code="Open"></spring:message></a>
	</c:if>
	
	<spring:eval expression="questionAttribute.createdAt"></spring:eval>
	<aripd:description id="questions">
		<aripd:descriptionitem label="Subject" field="${questionAttribute.subject}"></aripd:descriptionitem>
		<aripd:descriptionitem label="Content" field="${questionAttribute.content}"></aripd:descriptionitem>
	</aripd:description>
	
	<c:forEach var="answer" items="${questionAttribute.answers}">
	<blockquote>
		<p>${answer.content}</p>
		<small><spring:eval expression="answer.createdAt"></spring:eval>, ${answer.account.username}</small>
	</blockquote>
	</c:forEach>
	
	<spring:url var="answer_save" value="/user/answer/save/question/${questionAttribute.id}" />
	<form:form modelAttribute="answerAttribute" action="${answer_save}" method="post">
		<form:errors path="*" cssClass="error-block" element="div" />
		<form:hidden path="id" />
		<fieldset>
			<div class="control-group">
				<form:label path="content" class="control-label"><spring:message code="Content"></spring:message></form:label>
				<div class="controls"><form:textarea path="content" /></div>
				<form:errors cssClass="error-field" path="content" />
			</div>
			<div class="">
				<button class="btn" type="submit"><spring:message code="Send"></spring:message></button>
			</div>
		</fieldset>
	</form:form>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>