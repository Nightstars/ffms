<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>帐薄管理--添加</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body leftmargin="0" topmargin="0" onLoad="MM_preloadImages('${pageContext.request.contextPath}/images/login_10.gif','${pageContext.request.contextPath}/images/login_12.gif','${pageContext.request.contextPath}/images/login_09.gif','${pageContext.request.contextPath}/images/login_11.gif')">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 账簿管理 】</td>
          <td align="right">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
      <tr align="left" class="bg03">
        <td width="100%" height="29">
          <span class="text001">&nbsp;&nbsp;新增收支记录</span></td>
        </tr>

    </table>
      <table width="98%"  border="0" cellpadding="0" cellspacing="0" class="text008">
        <tr align="center">
          <td width="12%" height="35" align="right">收支类型</td>
          <td width="88%" align="left">
          <select class="inp001" id="accountAddType">
          	<option value="1">收入</option>
          	<option value="2">支出</option>
          </select>
          </td>
        </tr>
        <tr align="center" class="bg04">
          <td width="12%" height="35" align="right">父项目</td>
          <td width="88%" align="left">
          <select class="inp001" id="accountAddPItem">
            <c:forEach items="${items}" var="item">
              <c:if test="${item.pItem==null}">
                <option value="${item.id}">${item.name}</option>
              </c:if>
            </c:forEach>
          </select>
          </td>
        </tr>
        <tr align="center">
          <td width="12%" height="35" align="right">子项目</td>
          <td width="88%" align="left">
          <select class="inp001" id="accountAddCItem">
            <c:forEach items="${items}" var="item">
              <c:if test="${item.pItem!=null}">
                <option value="${item.id}">${item.name}</option>
              </c:if>
            </c:forEach>
          </select>
          </td>
        </tr>
        <tr align="center" class="bg04">
          <td height="35" align="right">收支日期</td>
          <td align="left"><input name="textfield" type="date" class="inp001" id="accountAddDate"></td>
        </tr>
        <tr align="center">
          <td height="35" align="right">收支家庭成员</td>
          <td align="left">
          <select class="inp001" id="accountAddUser">
            <c:forEach var="user" items="${user}">
              <option value="${user.id}">${user.name}</option>
            </c:forEach>
          </select>
          </td>
        </tr>
        <tr align="center" class="bg04">
          <td height="35" align="right">收支金额</td>
          <td align="left"><input name="textfield" type="text" class="inp001" id="accountAddAmount"></td>
        </tr>
        <tr align="center">
          <td height="168" align="right" valign="top" ><div class="mar009">备注</div></td>
          <td align="left" valign="top"><textarea name="textarea" class="inp002" id="accountAddRemark"></textarea>
         </td>
        </tr>
      </table>
      <table width="98%" border="0" cellpadding="0" cellspacing="0" class="bor001">
        <tr>
          <td width="100%" height="40" align="center" >
          <a onclick="addAccount()" target="mainframe" onMouseOver="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_2.gif',1)" onMouseUp="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_12_0.gif" name="Image1" width="75" height="24" border="0" id="Image1"></a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="toAccountList?pageNum=1&pageSize=10" target="mainframe" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_09.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_11.gif',1)" onMouseUp="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_09.gif',1)"><img src="${pageContext.request.contextPath}/images/login_07.gif" name="Image2" width="75" height="24" border="0" id="Image2"></a></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
