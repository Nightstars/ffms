<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--
Created by IntelliJ IDEA.
User: Chris
Date: 9/28/2019
Time: 12:01 AM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收支项目管理</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body topmargin="0" leftmargin="0">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 收支父项目管理 】</td>
          <td align="right">
          <a href="toItemAdd" target="mainframe" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_14_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_14_2.gif',1)" onMouseUp="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_15_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_14_0.gif" width="85" height="24" border="0" align="top" id="Image2"></a>&nbsp;&nbsp;<a onclick="itemListDeleteIPtems()" target="mainframe" onMouseOver="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_2.gif',1)" onMouseUp="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_13_0.gif" id="Image3" width="75" height="24" border="0"></a>
		  </td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
      <tr align="center" class="bg03">
        <td width="13%" height="29">
          <input type="checkbox" name="itemSelectAll" value="checkbox">
          <span class="text007">全选</span></td>
        <td width="22%" class="text007"> 收入/支出              </td>
        <td width="20%" class="text007">项目名称 </td>
        <td width="30%" class="text007">操作</td>
      </tr>
      <c:forEach items="${items}" var="item" varStatus="index">
        <c:if test="${item.pItem==null}">
            <c:choose>
                <c:when test="${index.index%2==0}">
                    <tr align="center">
                </c:when>
                <c:when test="${index.index%2!=0}">
                    <tr align="center" class="bg04">
                </c:when>
            </c:choose>
                <td height="35"><input type="checkbox" name="itemListCheckbox" value="checkbox" id="${item.id}"></td>
                <c:choose>
                    <c:when test="${item.type == 1}">
                        <td>收入</td>
                    </c:when>
                    <c:when test="${item.type ==2}">
                        <td>支出</td>
                    </c:when>
                </c:choose>
            <td align="center"><a href="listCItem?id=${item.id}">${item.name}</a></td>
            <td><a href="listCItem?id=${item.id}"><img src="${pageContext.request.contextPath}/images/icon_resault.gif" alt="查 看" width="12" height="15" hspace="10" border="0"></a><a href="toPItemEdit?id=${item.id}"><img src="${pageContext.request.contextPath}/images/icon_set.gif" alt="编 辑" width="14" height="15" border="0"></a><a onclick="return window.confirm('这条记录及其子项目将被删除且不可恢复，确认删除吗？')" href="deleteItem?id=${item.id}"><img src="${pageContext.request.contextPath}/images/delete.gif" alt="删 除" width="13" height="16" hspace="10"></a></td>
            </tr>
        </c:if>
      </c:forEach>

    </table>
      <table width="98%" border="0" cellpadding="0" cellspacing="0" class="bor001">
        <tr>
          <td height="40" align="left" >&nbsp;</td>
          <td align="right">
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
