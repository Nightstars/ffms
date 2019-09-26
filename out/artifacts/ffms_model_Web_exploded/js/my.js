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
                url:"loginServlet",
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
            url:"../listUserServlet",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,value) {
                    $("#userList").append(
                    "<tr align="+"\"center\""+">"+
                        "<td height="+"\"35\""+"><input type="+"\"checkbox\" "+"name="+"\"checkbox\" "+"value="+value.id+"></td>"+
                        "<td><a href="+"\"edit.html\""+">"+value.name+"</a> </td>"+
                    "<td>"+value.realname+"</td>"+
                    "<td>"+
                        "<a href="+"\"edit.html\""+">"+"<img src="+"\"../images/icon_set.gif\" "+"alt="+"'编 辑' "+"width='14' height='15' border='0'"+">"+"</a>"+
                        "<img src='../images/delete.gif' alt='删 除' width='13' height='16' hspace='10'>"+
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
            url:"../addUserServlet",
            data:{name:$("#userNameUserAdd").val(),realname:$("#userRealNameUserAdd").val(),pwd:$("#userPasswordUserAdd").val()},
            success:function (result) {
                if(result[0]=="o"&&result[1]=="k"){
                    window.location.href="list.html";
                }else{
                    alert(result);
                }
            },
            error:function (result) {
                alert("error");
            }
        });
    })
}