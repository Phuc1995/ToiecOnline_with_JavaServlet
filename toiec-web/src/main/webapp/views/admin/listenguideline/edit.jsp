<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                    </li>
                    <li class="active"><fmt:message key="label.guideline.listen.edit" bundle="${lang}"/></li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-block alert-${alert}">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                </button>
                                    ${messageResponse}
                            </div>
                        </c:if>

<%--                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">aaaaaaaaaaa</label>
                            <div class="col-sm-9">
                                <input type="text" value="JSP-Servlet Tesstttttttt" id="value">
                            </div>
                        </div>
                        <br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">aaaaaaaaaaa</label>
                            <div class="col-sm-9">
                                <<p class="Show">Nothing in this</p>
                            </div>
                        </div>
                        <label class="col-sm-3 control-label no-padding-right">aaaaaaaaaaa</label>
                        <div class="col-sm-9">
                            <button onclick="usingValAction()">Show info</button>
                        </div>--%>

                        <%--jQuery closest() Method--%>
                        <div style="width:500px;">div (great-grandparent)
                            <ul>ul (second ancestor - second grandparent)
                                <ul>ul (first ancestor - first grandparent)
                                    <li>li (direct parent)
                                        <span>span</span>
                                    </li>
                                </ul>
                            </ul>
                        </div>
                        </body>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {


        });
        function hideAllWhenClickButton() {
            $("#btnHide").click(function () {
                $(".textHide").hide();
            });
        }
        function usingValAction() {
                var value =       $("#value").val();
                $(".Show").html(value);
        }
    </script>
</body>
</html>
