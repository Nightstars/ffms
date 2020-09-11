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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>家庭成员管理</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body topmargin="0" leftmargin="0" onload="listUser();" >
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006">
      <table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 家庭成员管理 】</td>
          <td align="right"><a href="toUserAdd" target="mainframe" onMouseOver="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_2.gif',1)" onMouseUp="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_10_0.gif" width="75" height="24" border="0" align="top" id="Image1"></a>&nbsp;&nbsp;<a onclick="userListdeleteByarray()" target="mainframe" onMouseOver="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_2.gif',1)" onMouseUp="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_13_0.gif" id="Image3" width="75" height="24" border="0"></a>
		  </td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top">
    <table width="98%"  border="0" cellspacing="0" cellpadding="0" id="userList">
      <tr align="center" class="bg03">
        <td width="15%" height="29">
          <input type="checkbox" name="userListChkAll" value="checkbox">
          <span class="text007">全选</span></td>
        <td width="30%" class="text007"> 用户名 </td>
        <td width="35%" class="text007">真实姓名</td>
        <td width="20%" class="text007">操作</td>
      </tr>
	</table>
	</td></tr>
	<tr><td align=left valign=top>
		<hr  class="bor005" size="1"/>
	</td></tr>
</table>
</body>
</html>
