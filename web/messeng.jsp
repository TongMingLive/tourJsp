<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'show_message.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
    <style type="text/css">
        body {
            font-weight: normal;
            font-variant: normal;
            font-style: normal;
            font-size: 11px;
            font-family: auto, "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #4f6b72;
            background: #E6EAE9;
        }

        a {
            color: #c75f3e;
        }

        #mytable {
            width: 700px;
            padding: 0;
            margin: 0;
        }

        caption {
            padding: 0 0 5px 0;
            width: 700px;
            font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            text-align: right;
        }

        th {
            font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: green;
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            border-top: 1px solid #C1DAD7;
            letter-spacing: 2px;
            text-transform: uppercase;
            padding: 6px 6px 6px 12px;
            background: #CAE8EA no-repeat;
        }

        th.nobg {
            border-top: 0;
            border-left: 0;
            border-right: 1px solid #C1DAD7;
            background: none;
        }

        td {
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            background: #fff;
            font-size: 14px;
            padding: 6px 6px 6px 12px;
            color: #4f6b72;
        }

        td.alt {
            background: #F5FAFA;
            color: #797268;
        }

        th.spec {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #fff no-repeat;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        }

        th.specalt {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #f5fafa no-repeat;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #797268;
        }

        /*---------for IE 5.x bug*/
        html > body td {
            font-size: 14px;
            text-align: center;
            min-width: 50px;
        }

        body, td, th {
            font-family: 宋体, Arial;
            font-size: 14px;
        }
    </style>
    <c:if test="${empty sessionScope.userMessger }">
        <c:redirect url="index.jsp"/>
    </c:if>
</head>
<body>
<%
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");
    request.setCharacterEncoding("utf-8");

    String str = request.getParameter("str");
    String messengType = request.getParameter("messengType");
    System.out.println(messengType);
    String messengId = request.getParameter("messengId");
    String messengName = request.getParameter("messengName");
    String messengTitle = request.getParameter("messengTitle");
    String messengPage = request.getParameter("messengPage");
    String messengAddress = request.getParameter("messengAddress");
    String messengRoom = request.getParameter("messengRoom");
%>
<h3>
    &nbsp; <%=str%>信息详情
</h3>
<form action="UpdateMessengServlet" style="margin-top: 10px;margin-left: 50px">
    <input type="hidden" value="<%=messengId%>" name="messengId"/>
    <input type="hidden" value="<%=messengType%>" name="messengType"/>
    <h4><%=str%>名</h4>
    <input value="<%=messengName%>" name="messengName"/>
    <h4>介绍标题</h4>
    <input value="<%=messengTitle%>" name="messengTitle"/>
    <h4>介绍详情</h4>
    <textarea rows="12" cols="80" name="messengPage"><%=messengPage%></textarea>
    <h4>地址详情</h4>
    <input value="<%=messengAddress%>" name="messengAddress"/>
    <%if ("1".equals(messengType)){%>
    <h4>房间数量</h4>
    <input value="<%=messengRoom%>" name="messengRoom"/>
    <%}%>
    <h4></h4>
    <button type="submit">修改</button>
</form>

</body>
</html>