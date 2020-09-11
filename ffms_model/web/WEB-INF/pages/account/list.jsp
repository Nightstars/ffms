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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>帐薄管理</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script language="JavaScript" type="text/JavaScript" src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body topmargin="0" leftmargin="0">
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="32" align="left" valign="top" class="text006"><table width="98%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td>【 账簿管理 】</td>
          <td align="right"><a href="toAccountAdd" target="mainframe" onMouseOver="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_2.gif',1)" onMouseUp="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/index_10_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_10_0.gif" width="75" height="24" border="0" align="top" id="Image1"></a>&nbsp;&nbsp;<a href="#" target="mainframe" onMouseOver="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_2.gif',1)" onMouseUp="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/index_13_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_13_0.gif" id="Image3" width="75" height="24" border="0"></a>
		  &nbsp;<a href="toAccountFind" onMouseOver="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_1.gif',1)" onMouseOut="MM_swapImgRestore()" onMouseDown="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_2.gif',1)" onMouseUp="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/index_11_1.gif',1)"><img src="${pageContext.request.contextPath}/images/index_11_0.gif" width="75" height="24" border="0" align="top" id="Image2"></a></td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td height="215" valign="top">
      <table width="98%"  border="0" cellspacing="0" cellpadding="0">
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
      <c:forEach items="${accounts}" var="account" varStatus="index">
        <c:choose>
          <c:when test="${index.index%2==0}">
            <tr align="center">
          </c:when>
          <c:when test="${index.index%2!=0}">
            <tr align="center" class="bg04">
          </c:when>
        </c:choose>
          <td height="35"><input type="checkbox" name="checkbox" value="checkbox"></td>
          <td>${account.item.type==1?"收入":"支出"}</td>
          <td align="left"><a href="toAccountEdit">【${account.item.pName}】-${account.item.name} </a> </td>
          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${account.date}"></fmt:formatDate></td>
          <td>${account.user.name}</td>
          <td align="center" >${account.amount}</td>
          <td align="left">${account.remark}</td>
          <td><a href="showAccount?id=${account.id}"><img src="${pageContext.request.contextPath}/images/icon_resault.gif" alt="查 看" width="12" height="15" hspace="10" border="0"></a>
            <a href="toAccountEdit?id=${account.id}"><img src="${pageContext.request.contextPath}/images/icon_set.gif" alt="编 辑" width="14" height="15" border="0"></a>
            <a onclick="return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')" href="deleteAccount?id=${account.id}"><img src="${pageContext.request.contextPath}/images/delete.gif" alt="删 除" width="13" height="16" hspace="10"></a></td>
        </tr>
      </c:forEach>
    </table>
      <table width="98%" border="0" cellpadding="0" cellspacing="0" class="bor001">
        <%--<tr>
          <td height="40" align="left" >&nbsp;</td>
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
        </tr>--%>

        <tr>
          <td>
            <center>
              <nav aria-label="Page navigation">
                <ul class="pagination">
                  <li ${accounts.getPageNum()==1?"class='disabled'":""}>
                    <a href="${pageContext.request.contextPath}/toAccountList?pageNum=1&pageSize=${accounts.getPageSize()}" aria-label="Previous">
                      <span aria-hidden="true">first</span>
                    </a>
                  </li>
                  <li ${accounts.getPageNum()==1?"class='disabled'":""}>
                    <a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()-1}&pageSize=${accounts.getPageSize()}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      共${accounts.getTotal()}条记录
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      共${accounts.getPages()}页<br>
                    </a>
                  </li>
                  <li  style="${accounts.getPageNum()-2<1?"display:none":""}"><a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()-2}&pageSize=${accounts.getPageSize()}">${accounts.getPageNum()-2}</a></li>
                  <li style="${accounts.getPageNum()-1<1?"display:none":""}"><a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()-1}&pageSize=${accounts.getPageSize()}">${accounts.getPageNum()-1}</a></li>
                  <li class="active"><a href="#">${accounts.getPageNum()}</a></li>
                  <li style="${accounts.getPageNum()+1>accounts.getPages()?"display:none":""}"><a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()+1}&pageSize=${accounts.getPageSize()}">${accounts.getPageNum()+1}</a></li>
                  <li style="${accounts.getPageNum()+2>accounts.getPages()?"display:none":""}"><a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()+2}&pageSize=${accounts.getPageSize()}">${accounts.getPageNum()+2}</a></li>
                  <li>
            <span>
                每页显示&nbsp;&nbsp;<select name="pageSize" id="pageSize">
                <option value="5" name="5" ${accounts.getPageSize()==5?"selected":""}>5</option>
                <option value="6" name="6" ${accounts.getPageSize()==6?"selected":""}>6</option>
                <option value="7" name="7" ${accounts.getPageSize()==7?"selected":""}>7</option>
                <option value="8" name="8" ${usaccountsers.getPageSize()==8?"selected":""}>8</option>
                <option value="9" name="9" ${accounts.getPageSize()==9?"selected":""}>9</option>
                <option value="10" name="10" ${accounts.getPageSize()==10?"selected":""}>10</option>
            </select>
            </span>
                  </li>
                  <li>
            <span >
                跳转&nbsp;&nbsp;<input type="text" name="pages" style="width:30px;height:18px;">
            </span>
                  </li>
                  <li>
                    <a href="#">
                      go
                    </a>
                  </li>
                  <li class="${accounts.getPageNum()==accounts.getPages()?"disabled":""}">
                    <a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPageNum()+1}&pageSize=${accounts.getPageSize()}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                  <li class="${accounts.getPageNum()==accounts.getPages()?"disabled":""}">
                    <a href="${pageContext.request.contextPath}/toAccountList?pageNum=${accounts.getPages()}&pageSize=${accounts.getPageSize()}" aria-label="Previous">
                      <span aria-hidden="true">end</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </center>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
