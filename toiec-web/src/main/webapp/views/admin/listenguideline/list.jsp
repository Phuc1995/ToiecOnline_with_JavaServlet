
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <display:table name="testList" sort="external" defaultsort="1" id="element">
        <display:column property="id" title="ID" sortable="true" sortName="id" />
        <display:column property="firstName" sortable="true" sortName="firstName" title="First Name" />
        <display:column property="lastName" sortable="true" sortName="lastName" title="Last Name" />
        <display:column property="address" sortable="true" sortName="address" title="Email Address"/>
    </display:table>
</body>
</html>
