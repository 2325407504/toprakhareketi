<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="aripd" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

		<link rel="stylesheet" href="//code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css" />
		<link rel="stylesheet" href="/resources/css/master.css" />

		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.2.2/bootstrap.min.js"></script>
		<script type="text/javascript" src="/resources/js/master.js"></script>

  </head>

  <body>
  
		<spring:url var="homeUrl" value="/" />
		<spring:url var="loginUrl" value="/login" />
		<spring:url var="logoutUrl" value="/logout" />
		<spring:url var="profileShow" value="/profile/show" />
		<spring:url var="role_list" value="/role/list" />
		<spring:url var="account_list" value="/account/list" />
		<spring:url var="question_list" value="/question/list" />
		<spring:url var="user_question_list" value="/user/question/list" />

    <div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right">
					<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN')">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="Admin"></spring:message><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${role_list}"><spring:message code="Roles"></spring:message></a></li>
							<li><a href="${account_list}"><spring:message code="Accounts"></spring:message></a></li>
							<li class="divider"></li>
							<li><a href="${question_list}"><spring:message code="Questions"></spring:message></a></li>
						</ul>
					</li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					<li><a href="${user_question_list}"><spring:message code="Support"></spring:message></a></li>
					<li><a href="${profileShow}"><spring:message code="Profile"></spring:message></a></li>
					<li><a href="${logoutUrl}"><spring:message code="Logout"></spring:message></a></li>
					</sec:authorize>
					<li class="dropdown">
						<c:set var="localeCode" value="${pageContext.response.locale}" />
						<c:set var="availLanguages" value="tr_TR,en_US" />
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="Language" text="Language"></spring:message>: ${localeCode}<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:if test="${!fn:contains(availLanguages,localeCode)}">
								<c:set var="localeCode" value="tr_TR" />
							</c:if>
							<c:forEach items="${availLanguages}" var="lang">
								<li><a href="?language=${lang}">${lang} <c:if test="${fn:contains(localeCode, lang)}"><i class="icon-ok"></i></c:if></a></li>
							</c:forEach>
						</ul>
					</li>
        </ul>
        <h3 class="muted">Toprak Hareketi</h3>
      </div>

      <hr>