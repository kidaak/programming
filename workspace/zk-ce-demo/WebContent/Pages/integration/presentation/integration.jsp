<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<title>Insert title here</title>
</head>
<body style="height: auto;">
	<%
		request.setAttribute(org.zkoss.zk.ui.sys.Attributes.NO_CACHE,
				Boolean.TRUE);
	%>
	<z:page>
		<form action="/foo/legacy">
			<table>
				<tr>
					<td>When</td>
					<td><z:datebox name="when" /></td>
				</tr>
				<tr>
					<td>Which></td>
					<td><z:listbox name="which">
							<z:listitem label="choice 1" />
							<z:listitem label="choice 2" />
						</z:listbox></td>
				</tr>
				<tr>
					<td><z:button type="submit" label="Submit" /></td>
					<td><z:button type="reset" label="Reset" /></td>
				</tr>
				</form>
				</z:page>
				<jsp:include page="/Pages/international/timezone.zul"></jsp:include>
</body>
</html>