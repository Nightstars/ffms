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
<title>帐薄管理--查询结果</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body topmargin="0" leftmargin="0">
${accounts}
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006">
    <table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 账簿管理 】</td>
          <td align="right">&nbsp;
          </td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="25">&nbsp;&nbsp;
        开始日期:<input name="textfield" type="date" class="inp001" name="start" id="findAccountStart">
        结束日期:<input name="textfield" type="date" class="inp001" name="end" id="findAccountEnd">
        <a onclick="findAccount()" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_2.gif',1)" onMouseUp="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_11_0.gif" width="75" height="24" border="0" align="top" id="Image2"></a>
        
        </td>
        <td>
        <a href="#" target="mainframe" onMouseOver="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_2.gif',1)" onMouseUp="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_13_0.gif" id="Image3" width="75" height="24" border="0"></a> &nbsp;
      	</td>
      </tr>
    </table>
    <table width="98%"  border="0" cellspacing="0" cellpadding="0" id="findAccountResult">
      <tr align="center" class="bg03">
        <td height="29">
          <input type="checkbox" name="checkbox" value="checkbox"> 
          <span class="text007">全选</span></td>
        <td class="text007">收入/支出</td>
        <td class="text007">项目名称 </td>        
        <td class="text007">日期</td>
        <td class="text007">家庭成员</td>
        <td class="text007">金额</td>
        <td class="text007">备注</td>
        <td class="text007">操作</td>
      </tr>
    </table>
      <table width="98%" border="0" cellpadding="0" cellspacing="0" class="bor001">
        <tr>
          <td height="30" align="left" >&nbsp;</td>
          <td align="right">每页显示
              <select name="menu1">
                <option selected>11</option>
                <option>15</option>
                <option>20</option>
                <option>30</option>
                <option>50</option>
            </select>
      条&nbsp;&nbsp;10/25页&nbsp;&nbsp;首页 | <a href="#" class="tex04">上一页</a> | <a href="#" class="tex04">下一页</a> | 末页
      <input class="InputText" type="text" id="pagego" style="width:30px;" />
      <input class="input_button" name="go" type="submit" id="go" value="GO" />
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
