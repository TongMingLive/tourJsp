<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.tour.dao.UserDao" %>
<%@ page import="com.tour.bean.User" %>
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
<h3>
    &nbsp; 所有用户信息展现中心
</h3>
<table id="mytable" cellspacing="0">
    <caption>
    </caption>
    <tr>
        <th scope="col">UID</th>
        <th scope="col">用户名</th>
        <th scope="col">管理员</th>

		<th scope="col" width="50">操作</th>
        <th scope="col">操作</th>
    </tr>
    <%
        UserDao dao = new UserDao();
        List<User> list = dao.selectAllUser();
        for (int i = 0; i < list.size(); i++) {
    %>
	<form action="UpdateUserTypeServlet" method="post">
	    <tr>
	        <td>
				<%=list.get(i).getUserId()%>
				<input type="hidden" value="<%=list.get(i).getUserId()%>" name="userId"/>
			</td>
	        <td><%=list.get(i).getUserName()%></td>
	        <td>
				<select name="userType">
					<%
						if (list.get(i).getUserType() == 0) {
					%>
					<option value="0" selected="selected">否</option>
					<option value="1">是</option>
					<% } else { %>
					<option value="0">否</option>
					<option value="1" selected="selected">是</option>
					<% } %>
				</select>
	        </td>

	        <td class="row">
                <% if (list.get(i).getUserType() != 1){%>
	            <a href="DeleteUserServlet?userId=<%=list.get(i).getUserId()%>">删除</a>
                <%}%>
	        </td>
			<td class="row" style="min-width: 70px">
				<button type="submit">保存修改</button>
			</td>
	    </tr>
    </form>
    <%
        }
    %>
</table>
</body>
</html>
