
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title><dec:title default="Admin Page"/> </title>
    <dec:head/>

</head>
<body>
    <!-- Header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- End Header -->

    <!-- Begin menu -->
    <%@ include file="/common/admin/menu.jsp" %>
    <!-- End menu -->

    <!-- Begin body -->
    <dec:body/>
    <!-- End body -->

    <!-- Begin footer -->
    <%@ include file="/common/admin/footer.jsp" %>
    <!-- end footer -->
</body>
</html>
