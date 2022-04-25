<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="authenticated.announcement.form.label.title" path="title" readonly="true"/>
	<acme:input-textbox code="authenticated.announcement.form.label.creation" path="creation" readonly="true"/>
	<acme:input-url code="authenticated.announcement.form.label.link" path="link"/>
	<acme:input-textbox code="authenticated.announcement.form.label.critic" path="critic" readonly="true"/>
	
	<acme:button code="authenticated.announcement.form.buttom.announcements" action="/authenticated/announcements/list-by-announcement?id=${id}"/>
</acme:form>