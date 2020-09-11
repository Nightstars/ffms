var name;
function login() {
    $(function () {
        $name=$("#username").val();
        name=$name;
        $password=$("#password").val();
        if($name==null||$name==""){
            $("#loginInfo").text("用户名不能为空");
        }else if($password==null||$password==""){
            $("#loginInfo").text("密码名不能为空");
        }else {
            $.ajax({
                type:"POST",
                url:"toHome.html",
                data:"name="+$name+"&password="+$password,
                success:function (result) {
                    if(result[0]=="o"&&result[1]=="k"){
                        window.location.href="home.html";
                    }else{
                        $("#loginInfo").text(result);
                    }
                },
                error:function (result) {
                    alert(result);
                }
            });
        }
    });
}
function listUser() {
    $(function () {
        $.ajax({
            type:"POST",
            url:"listUser",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#userList").append(
                    "<tr align="+"\"center\""+">"+
                        "<td height="+"\"35\""+"><input type="+"\"checkbox\" "+"name="+"\"userListCheckbox\" "+"id="+value.id+"></td>"+
                        "<td><a href="+"\"toUserDetail?id="+value.id+"\""+">"+value.name+"</a> </td>"+
                        "<td>"+value.realname+"</td>"+
                        "<td>"+
                            "<a href="+"\"toUserEdit?id="+value.id+"\">"+"<img src="+"\"/ffms/images/icon_set.gif\" "+"alt="+"'编 辑' "+"width='14' height='15' border='0'"+">"+"</a>"+
                             '<a onclick="return window.confirm(\'这条记录将被删除且不可恢复，确认删除吗？\')" href="deleteUser?id='+value.id+'">'+
                            "<img src='/ffms/images/delete.gif' alt='删 除' width='13' height='16' hspace='10'>"+'</a>'+
                        "</td>"+
                    "</tr>"
                    );
                })
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function showUserName() {
    $(function () {
        $("#userNameHome").text(name);
    })
}
function addUser() {
    $(function () {
        $.ajax({
            type:"post",
            url:"addUser",
            data:{name:$("#userNameUserAdd").val(),realname:$("#userRealNameUserAdd").val(),pwd:$("#userPasswordUserAdd").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function userModifycheck() {
    //完成客户端验证
    //用户名、真实姓名不为空
    //两个密码相同
    //提交表单
    $(function () {
        if($("#userModifyName").val()==null||$("#userModifyName").val()==""){
            $("#userModifyShowInfo").text("用户名不能为空");
        }else if($("#userModifyRealName").val()==null||$("#userModifyRealName").val()==""){
            $("#userModifyShowInfo").text("真实姓名不能为空");
        }else if($("#userModifyPwd").val()==null||$("#userModifyPwd").val()==""){
            $("#userModifyShowInfo").text("密码不能为空");
        }else if($("#userModifyRePwd").val()==null||$("#userModifyRePwd").val()==""){
            $("#userModifyShowInfo").text("确认密码不能为空");
        }else if(!($("#userModifyPwd").val()==$("#userModifyRePwd").val())){
            $("#userModifyShowInfo").text("两次输入密码不一致");
        }else {
            modifyUser();
        }
   });
}
function modifyUser() {
    $(function () {
        $.ajax({
            type:"post",
            url:"modifyUser",
            data:{id:$("#id").val(),name:$("#userModifyName").val(),realname:$("#userModifyRealName").val(),pwd:$("#userModifyPwd").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function modifyPItem() {
    $(function () {
        $.ajax({
            type:"post",
            url:"editPItem",
            data:{id:$("#editPItemId").val(),type:$("#editPItemType").val(),name:$("#editPItemName").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function modifyCItem() {
    $(function () {
        $.ajax({
            type:"post",
            url:"editCItem",
            data:{id:$("#ceditItemId").val(),type:$("#editCItemType").val(),name:$("#editCItemName").val()},
            success:function (result) {
                window.location.href=result+"?id="+$("#ceditItemPId").val();
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function addItem() {
    $(function () {
        $.ajax({
            type:"post",
            url:"itemAdd",
            data:{type:$("#itemAddType").val(),name:$("#itemAddName").val(),PId:$("#itemAddPItem").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function deleteItem() {
    $(function () {
        $.ajax({
            type:"post",
            url:"deleteCItem",
            data:{id:$("#deleteItemId").val(),PId:$("#deleteItemPId").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
$(function () {
    $("#itemAddType").change(function () {
        $.ajax({
            type:"post",
            url:"pItem?id="+$("#itemAddType").val(),
            success:function (result) {
                $("#itemAddPItem").empty();
                $("#itemAddPItem").append('<option value="0">父项目</option>');
                $.each(result,function (index,value) {
                    $("#itemAddPItem").append('<option value="'+value.id+'">'+value.name+'</option>');
                });
            },
            error:function (result) {
                alert("error");
            }
        });
    });
})
$(function () {
    $("#accountAddType").change(function () {
        $.ajax({
            type:"post",
            url:"pItem?id="+$("#accountAddType").val(),
            success:function (result) {
                $("#itemAddPItem").empty();
                $("#itemAddPItem").append('<option value="0">父项目</option>');
                $.each(result,function (index,value) {
                    $("#itemAddPItem").append('<option value="'+value.id+'">'+value.name+'</option>');
                });
            },
            error:function (result) {
                alert("error");
            }
        });
    });
})
function addAccount() {
    $(function () {
        $.ajax({
            type:"post",
            url:"addAccount?uid="+$("#accountAddUser").val()+"&iid="+$("#accountAddCItem").val(),
            data:{date:$("#accountAddDate").val(),amount:$("#accountAddAmount").val(),remark:$("#accountAddRemark").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function editAccount() {
    $(function () {
        $.ajax({
            type:"post",
            url:"editAccount?uid="+$("#accountEditUser").val()+"&iid="+$("#accountEditCItem").val(),
            data:{id:$("#accountEditId").val(),date:$("#accountEditDate").val(),amount:$("#accountEditAmount").val(),remark:$("#accountEditRemark").val()},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
function findAccount() {
    $(function () {
        $.ajax({
            type:"post",
            url:"findAccount",
            data:{start:$("#findAccountStart").val(),end:$("#findAccountEnd").val()},
            success:function (result) {
                $.each(result,function (index,value) {
                    var type;
                    value.item.type==1?type = "收入":type="支出";
                    var date=new Date(value.date);
                    var newdate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
                    $("#findAccountResult").append(
                        '<tr align="center">' +
                        '        <td height="35"><input type="checkbox" name="checkbox" value="'+value.id+'"></td>' +
                        '        <td>'+type+'</td>' +
                        '        <td align="left"><a href="toAccountEdit?id='+value.id+'">【'+value.item.name+'】-'+value.item.name+' </a> </td>' +
                        '        <td>'+newdate+'</td>' +
                        '        <td>'+value.user.name+'</td>' +
                        '        <td align="right">'+value.amount+'&nbsp;&nbsp;</td>\n' +
                        '        <td align="left">'+value.remark+'</td>' +
                        '        <td><a href="showAccount?id='+value.id+'"><img src="/ffms/images/icon_resault.gif" alt="查 看" width="12" height="15" hspace="10" border="0"></a>' +
                        '        <a href="toAccountEdit?id='+value.id+'"><img src="/ffms/images/icon_set.gif" alt="编 辑" width="14" height="15" border="0"></a>\n' +
                        '        <a onclick="return window.confirm(\'这条记录将被删除且不可恢复，确认删除吗？\')" href="deleteAccount?id='+value.id+'"><img src="/ffms/images/delete.gif" alt="删 除" width="13" height="16" hspace="10"></a></td>' +
                        '      </tr>'
                    );
                });
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}
$(function(){
    //实现全选与反选
    $("input[name='userListChkAll']").click(function() {
        if (this.checked){
            $("input[name='userListCheckbox']:checkbox").each(function(){
                $(this).attr("checked", true);
            });
        } else {
            $("input[name='userListCheckbox']:checkbox").each(function() {
                $(this).attr("checked", false);
            });
        }
    });

    //实现全选与反选
    $("input[name='itemSelectAll']").click(function() {
        if (this.checked){
            $("input[name='itemListCheckbox']:checkbox").each(function(){
                $(this).attr("checked", true);
            });
        } else {
            $("input[name='itemListCheckbox']:checkbox").each(function() {
                $(this).attr("checked", false);
            });
        }
    });

    $("input[name='itemCListChk']").click(function() {
        if (this.checked){
            $("input[name='itemCListCheck']:checkbox").each(function(){
                $(this).attr("checked", true);
            });
        } else {
            $("input[name='itemCListCheck']:checkbox").each(function() {
                $(this).attr("checked", false);
            });
        }
    });
});
function userListdeleteByarray() {
    $(function () {
        var ids=[];
        $("input[name='userListCheckbox']:checked").each(function(){
            ids.push($(this).attr("id"));
        });
        var delIds=ids.join(",");
        $.ajax({
            type:"post",
            url:"deleteUserArray",
            data:{arr:delIds},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    });
}
function itemListDeleteIPtems() {
    $(function () {
        var ids=[];
        $("input[name='itemListCheckbox']:checked").each(function(){
            ids.push($(this).attr("id"));
        });
        var delIds=ids.join(",");
        $.ajax({
            type:"post",
            url:"deletePItems",
            data:{arr:delIds},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    });
}
function itemListDeleteCtems() {
    $(function () {
        var ids=[];
        $("input[name='itemCListCheck']:checked").each(function(){
            ids.push($(this).attr("id"));
        });
        var delIds=ids.join(",");
        $.ajax({
            type:"post",
            url:"deleteCItems",
            data:{arr:delIds},
            success:function (result) {
                window.location.href=result;
            },
            error:function (result) {
                alert("error");
            }
        });
    });
}