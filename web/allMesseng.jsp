<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.tour.dao.MessengDao" %>
<%@ page import="com.tour.bean.Messeng" %>
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

    String messengType = request.getParameter("messengType");
    int type;
    String str;
    if (messengType.equals("0")) {
        type = 0;
        str = "景点";
    } else if (messengType.equals("1")) {
        type = 1;
        str = "酒店";
    } else {
        type = 2;
        str = "美食";
    }
%>
<h3>
    &nbsp; 所有<%=str%>信息展现中心
</h3>
<table id="mytable" cellspacing="0">
    <caption>
    </caption>
    <tr>
        <th scope="col">ID</th>
        <th scope="col"><%=str%>名</th>
        <th scope="col">介绍标题</th>
        <th scope="col">介绍详情</th>
        <th scope="col">地址详情</th>
        <%if (messengType.equals("1")){%>
        <th scope="col">房间</th>
        <%}%>
        <th scope="col" width="50">操作</th>
        <th scope="col" width="50">操作</th>
    </tr>
    <%
        MessengDao dao = new MessengDao();
        List<Messeng> list = dao.selectMesseng(type);
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td><%=list.get(i).getMessengId()%>
        </td>
        <td style="min-width: 100px"><%=list.get(i).getMessengName()%>
        </td>
        <td style="min-width: 150px">
            <% if (list.get(i).getMessengTitle().length() > 10) {%>
            <%=list.get(i).getMessengTitle().substring(0, 9) + "..."%>
            <%} else {%>
            <%=list.get(i).getMessengTitle()%>
            <%}%>
        </td>
        <td style="min-width: 150px">
            <% if (list.get(i).getMessengPage().length() > 10) {%>
            <%=list.get(i).getMessengPage().substring(0, 9) + "..."%>
            <%} else {%>
            <%=list.get(i).getMessengPage()%>
            <%}%>
        </td>
        <td style="min-width: 150px">
            <% if (list.get(i).getMessengAddress().length() > 10) {%>
            <%=list.get(i).getMessengAddress().substring(0, 9) + "..."%>
            <%} else {%>
            <%=list.get(i).getMessengAddress()%>
            <%}%>
        </td>
        <%if (messengType != null && messengType.equals("1")){%>
        <td><%=list.get(i).getMessengRoom()%></td>
        <%}%>
        <td class="row">
            <a href="DeleteMessengServlet?messengId=<%=list.get(i).getMessengId()%>">删除</a>
        </td>
        <td class="row" style="min-width: 70px">
            <a href="messeng.jsp?messengType=<%=messengType%>&str=<%=str%>&messengId=<%=list.get(i).getMessengId()%>&messengName=<%=list.get(i).getMessengName()%>&messengTitle=<%=list.get(i).getMessengTitle()%>&messengPage=<%=list.get(i).getMessengPage()%>&messengAddress=<%=list.get(i).getMessengAddress()%>&messengRoom=<%=list.get(i).getMessengRoom()%>">修改</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
