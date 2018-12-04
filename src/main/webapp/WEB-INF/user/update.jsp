<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" language="javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript" src="js/DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="../res/css/style.css" />
<title>user-update</title>
<script type="text/javascript">

//用户名：不能全部为数字，6-16位
var CHKLOGINNAME = "^[a-zA-Z][a-zA-Z0-9_]{6,16}$";
//邮箱正则，可以包含_ 
var CHKEMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$";
//真实姓名，纯汉字，2位及以上
var CHKREALNAME = "^[\u4e00-\u9fa5]{2,}$";

//验证用户名
function chkloginname(){
	//获取用户名
	var loginname=$("#loginname").val();
	//定义用户匹配的正则表达式
	var reg=new RegExp(CHKLOGINNAME);
	if (reg.test(loginname)) {
		$("#resultName").html("✔");
		$("#resultName").css("color","green");
		return true;
	} else {
		$("#resultName").html("用户名必须包含字母和数字，不小于六位");
		$("#resultName").css("color","red");
		$("#loginname").val();
		$("#loginname").focus();
		return false;
	}
}
function chkrealname(){
	//获取真实名
	var realname=$("#realname").val();
	//定义真实姓名匹配的正则表达式
	var reg=new RegExp(CHKREALNAME);
	if (reg.test(realname)) {//表示输入正确
		$("#resultRename").html("✔");
		$("#resultRename").css("color","green");
		return true;
	} else {//输入失败 
		$("#resultRename").html("真实姓名必须只能是汉字，并且不能低于一位");
		$("#resultRename").css("color","red");
		$("#realname").val();
		$("#realname").focus();
		return false;
	}
}
function chkemail(){
	//获取邮箱
	var email=$("#email").val();
	//定义真实姓名匹配的正则表达式
	var reg=new RegExp(CHKEMAIL);
	if (reg.test(email)) {//表示输入正确
		$("#resultEmail").html("✔");
		$("#resultEmail").css("color","green");
		return true;
	} else {//输入失败
		$("#resultEmail").html("邮箱格式不对");
		$("#resultEmail").css("color","red");
		$("#email").val();
		$("#email").focus();
		return false;
	}
}

</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 用户管理 - 修改</div>
	<form class="ropt">
		<input style="margin-left:100px;" type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="padding:30px;margin:30px 0 0 100px">
	<form id="jvForm" action="update.do?id=${USER.id }" method="post">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired"></span>
						<span class="pn-frequired">${msg}</span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						用户名:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="loginname" id="loginname" maxlength="100" value="${user.loginname }" onblur="chkloginname()"/>
						<span id="resultName"></span>
					</td>
				</tr>
				
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						真实姓名:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="realname" id="realname" maxlength="100"  value="${user.realname }" onblur="chkrealname()"/>
						<span id="resultRename"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						性别:</td><td width="80%" class="pn-fcontent">
						<c:if test="${USER.sex=='男' }">
						<input type="radio" name="sex" value="男" checked="checked"/>男
						<input type="radio" name="sex" value="女"/>女
						</c:if>
						<c:if test="${USER.sex!='男' }">
							<input type="radio" name="sex" value="男" />男
						<input type="radio" name="sex" value="女" checked="checked"/>女
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						出生日期:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" name="birthdayTxt" maxlength="80" value="${USER.birthdayTxt }"
						onclick="WdatePicker()"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						部门:</td><td width="80%" class="pn-fcontent">
						<select id="dep1" name="dep1">
							<c:forEach items="${DLIST}" var="d1">
							<!-- 显示所属部门 -->
							<c:if test="${USER.dept.pid==d1.id }">
							<option value="${d1.id}" selected="selected">${d1.name}</option>
							</c:if>
								<!-- 显示其他部门 -->
								<c:if test="${USER.dept.pid!=d1.id }">
								<option value="${d1.id}" >${d1.name}</option></c:if>
							</c:forEach>
					</select>
					<select id="dep2" name="dept.id">
						<c:forEach items="${DLIST2}" var="d2">
							<!-- 显示所属部门 -->
							<c:if test="${USER.dept.id==d2.id }">
								<option value="${d2.id}" selected="selected">${d2.name}</option>
							</c:if>
							<!-- 显示其他部门 -->
							<c:if test="${USER.dept.id!=d2.id }">
								<option value="${d2.id}" >${d2.name}</option>
							</c:if>
						</c:forEach>
					</select>
					
					<input type="hidden" name="isenabled" value="${USER.isenabled }" ></input>
					<input type="hidden" name="id" value="${USER.id }" ></input>
					
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<c:if test="${user.enabled==1 }">
						<input type="radio" class="required" name="enabled"  maxlength="80" value="1" checked="checked"/>可用
						<input type="radio" class="required" name="enabled"  maxlength="80" value="2"/>不可用
						</c:if>
						<c:if test="${user.enabled==2 }">
						<input type="radio" class="required" name="enabled" maxlength="80" value="1"/>可用
						<input type="radio" class="required" name="enabled" maxlength="80" value="2" checked="checked"/>不可用
						</c:if>
						</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						邮箱:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="email" id="email" maxlength="80" value="${user.email }" onblur="chkemail()"/>
						<span id="resultEmail"></span>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit"  value="提交"/> &nbsp; 
						<input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>