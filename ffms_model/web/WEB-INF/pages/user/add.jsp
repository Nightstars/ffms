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
<title>家庭成员管理--添加</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
<script>
function check() {
	//完成客户端验证
	//用户名、真实姓名不为空
	//两个密码相同
	//提交表单
  $(function () {
    if($("#userNameUserAdd").val()==null||$("#userNameUserAdd").val()==""){
      $("#showInfo").text("用户名不能为空");
    }else if($("#userRealNameUserAdd").val()==null||$("#userRealNameUserAdd").val()==""){
      $("#showInfo").text("真实姓名不能为空");
    }else if($("#userPasswordUserAdd").val()==null||$("#userPasswordUserAdd").val()==""){
      $("#showInfo").text("密码不能为空");
    }else if($("#userRePasswordUserAdd").val()==null||$("#userRePasswordUserAdd").val()==""){
      $("#showInfo").text("确认密码不能为空");
    }else if(!($("#userPasswordUserAdd").val()==$("#userRePasswordUserAdd").val())){
      $("#showInfo").text("两次输入密码不一致");
    }else {
      addUser();
    }
  });
}
</script>
</head>

<body leftmargin="0" topmargin="0" onLoad="MM_preloadImages('${pageContext.request.contextPath}/images/login_10.gif','${pageContext.request.contextPath}/images/login_12.gif','${pageContext.request.contextPath}/images/login_09.gif','../images/login_11.gif')">

<form name="myform" action="list.jsp">

<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 家庭成员管理 】</td>
          <td align="right">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
      <tr align="left" class="bg03">
        <td width="100%" height="29">
          <span class="text001">&nbsp;&nbsp;新增家庭成员</span></td>
        </tr>

    </table>
      <table width="98%"  border="0" cellpadding="0" cellspacing="0" class="text008">
        <tr align="center"><td colspan="2" style="color: red"><span id="showInfo"></span></td></tr>
        <tr align="center">
          <td width="12%" height="35" align="right">用户名</td>
          <td width="88%" align="left"><input name="textfield" type="text" class="inp001" id="userNameUserAdd"></td>
        </tr>
        <tr align="center" class="bg04">
          <td height="35" align="right">真实姓名</td>
          <td align="left"><input name="textfield" type="text" class="inp001" id="userRealNameUserAdd"></td>
        </tr>
        <tr align="center">
          <td height="35" align="right">输入密码</td>
          <td align="left"><input name="pwd" type="password" class="inp001" id="userPasswordUserAdd"></td>
        </tr>
        <tr align="center" class="bg04">
          <td height="35" align="right">确认密码</td>
          <td align="left"><input name="pwd1" type="password" class="inp001" id="userRePasswordUserAdd"></td>
        </tr>
      </table>
      <table width="98%" border="0" cellpadding="0" cellspacing="0" class="bor001">
        <tr>
          <td width="100%" height="40" align="left" style="padding-left:  55px;padding-top: 10px;">
          <a   onclick="check()" target="mainframe" onMouseOver="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_2.gif',1)" onMouseUp="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_12_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_12_0.gif" name="Image1" width="75" height="24" border="0" id="Image1"></a >&nbsp;&nbsp;&nbsp;&nbsp;<a href="toUserList" target="mainframe" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_09.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_11.gif',1)" onMouseUp="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/login_09.gif',1)"><img src="${pageContext.request.contextPath}/images/login_07.gif" name="Image2" width="75" height="24" border="0" id="Image2"></a></td>
<%--          <td width="78%" align="right">&nbsp </td>--%>
        </tr>
      </table>
    </td>
  </tr>
</table>

</form>
</body>
</html>
