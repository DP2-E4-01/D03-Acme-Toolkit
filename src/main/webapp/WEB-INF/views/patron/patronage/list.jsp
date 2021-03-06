

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.patron.patronage.list.label.status" path="status" width="20%"/>
	<acme:list-column code="authenticated.patron.patronage.list.label.code" path="code" width="10%"/>
	<acme:list-column code="authenticated.patron.patronage.list.label.legalStuff" path="legalStuff" width="20%"/>
	<acme:list-column code="authenticated.patron.patronage.list.label.budget" path="budget" width="10%"/>
	<acme:list-column code="authenticated.patron.patronage.list.label.startsAt" path="startsAt" width="10%"/>
	<acme:list-column code="authenticated.patron.patronage.list.label.finishesAt" path="finishesAt" width="10%"/>
</acme:list>

