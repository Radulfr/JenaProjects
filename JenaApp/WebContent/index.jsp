<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jena App v 0.1</title>
</head>
<body>
<h1>Hello :D</h1>
<p> The purpose of this app is to get habilities with Apache Jena Framework. </p>

<s:form action="getURI">
	<s:textfield name="uri" label="Put here your URI"/>
	<s:submit name="Send" value="Get URI"></s:submit>
</s:form>
</body>
</html>