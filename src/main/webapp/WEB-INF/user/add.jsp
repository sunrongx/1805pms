<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="res/lecheng/css/admin.css" rel="stylesheet" type="text/css" />
<link href="res/common/css/theme.css" rel="stylesheet" type="text/css" />
<link href="res/common/css/jquery.validate.css" rel="stylesheet"
	type="text/css" />
<link href="res/common/css/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<link href="res/common/css/jquery.ui.css" rel="stylesheet"
	type="text/css" />

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="res/common/js/jquery.js" type="text/javascript"></script>
<script src="res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="res/common/js/lecheng.js" type="text/javascript"></script>
<script src="res/lecheng/js/admin.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" language="javascript"
	src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript"
	src="js/DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="res/css/style.css" />
<title>user-add</title>
<!-- 添加表单验证 -->
<script type="text/javascript">
	//用户名：不能全部为数字，6-16位
	var CHKLOGINNAME = "^[a-zA-Z][a-zA-Z0-9_]{6,16}$";
	//密码：数字+字母，结束之前不能全部都是数字和字母，6-16位
	var CHKPASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,16}$";
	//出生日期 yyyy-MM-dd， 月1-12 日1-31
	var CHKDATE = "^[0-9]{4}-0?[1-9]|1[0-2]-0?[1-9]|[1-2][0-9]|3[0-1]$";
	//邮箱正则，可以包含_ 
	var CHKEMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$";
	//真实姓名，纯汉字，2位及以上
	var CHKREALNAME = "^[\u4e00-\u9fa5]{2,}$";
	//验证用户名
	function chkloginname() {
		//获取用户名
		var loginname=$("#loginname").val();
		//定义用户匹配的正则表达式
		var reg=new RegExp(CHKLOGINNAME);
		if (reg.test(loginname)) {
		if(chkExistLoginname(loginname)){
			return true;
		}else{
			return false;
		}
		} else {
			$("#resultName").html("用户名必须包含字母，以字母开头且不小于六位");
			$("#resultName").css("color","red");
			$("#loginname").val();
			$("#loginname").focus();
		   return false;
		}
	}
	//检查用户名是否重复
	function chkExistLoginname(loginname){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=1&loginname='+loginname,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if (flag=='true') {//没有重复
					$("#resultName").html("✔");
					$("#resultName").css("color","green");
					flag=true;
				} else {
					$("#resultName").html("此用户已存在");
					$("#resultName").css("color","red");
					flag=false;
				}
			}
		});
		return flag;
	}
	//检测邮箱是否重复
	//检查用户名是否重复
	function chkExistEmail(email){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=2&email='+email,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if (flag=='true') {//没有重复
					$("#resultEmail").html("✔");
					$("#resultEmail").css("color","green");
					flag=true;
				} else {
					$("#resultEmail").html("此邮箱已存在！");
					$("#resultEmail").css("color","red");
					flag=false;
				}
			}
		});
		return flag;
	}
//验证密码
	function chkpassword() {
		//获取密码
		var password=$("#password").val();
		//定义密码匹配的正则表达式
		var reg=new RegExp(CHKPASSWORD);
		if (reg.test(password)) {
			$("#resultPwd").html("✔");
			$("#resultPwd").css("color","green");
			return true;	
	       } else {
			$("#resultPwd").html("密码必须包含字母和数字，不小于六位！");
			$("#resultPwd").css("color","red");
			$("#password").val();
			$("#password").focus();
			return false;
		}
	}

	//验证两次密码是否一致
	function chkRePwd() {
		//获取密码
		//获取密码
		var repwdEle=$("#repwd").val();
		var password=$("#password").val();
       if (repwdEle == password) {
			$("#resultRepwd").html("✔");
			$("#resultRepwd").css("color","green");
			return true;
		} else {
			$("#resultRepwd").html("两次密码不一致");
			$("#resultRepwd").css("color","red");
			$("#repwd").val();
			$("#repwd").focus();
			return false;
		}
	}
	function chkrealname() {
		//获取真实名
		var realname=$("#realname").val();
		//定义真实姓名匹配的正则表达式
		var reg=new RegExp(CHKREALNAME);
		if (reg.test(realname)) {//表示输入正确
			$("#resultRename").html("✔");
			$("#resultRename").css("color","green");
			return true;
		} else {//输入失败 
			$("#resultRename").html("真实姓名必须是汉字，至少两位");
			$("#resultRename").css("color","red");
			$("#realname").val();
			$("#realname").focus();
			return false;
		}
	}
	
	
	function chkemail() {
		//获取邮箱
		var email=$("#email").val();
		//定义真实姓名匹配的正则表达式
		var reg=new RegExp(CHKEMAIL);
		if (reg.test(email)) {//表示输入正确
			if(chkExistEmail(email)){
				return true;
			}else{
			return false;
			}
		} else {//输入失败
			$("#resultEmail").html("邮箱格式不正确");
			$("#resultEmail").css("color","red");
			$("#email").val();
			$("#email").focus();
			return false;
		}
	}
	
	//文档就绪事件
	$(function(){
		//下拉框change事件
		$("#dep1").change(function(){
				//ajax的异步提交
				$.post("getdep.do",	//url
					{
						pid:this.value	
					},	//json类型数据传值
					function(data){
						alert(data);
						
					},	//成功后执行
					"json"	//返回类型
				);
		});
	});
	
	function dep(){
		//清空第二个下拉框
		$("#dep2").empty();
		//ajax的异步提交
		$.post("getdep.do",	//url
			{
				pid:this.value
			},	//json类型数据传值
			function(data){
				if(data!=null){
					$(data).each(
						function(){
							//添加数据到第二个下拉框中
							$("#dep2").append("<option value="+this.id+">"+this.name+"</option>");
						}
					);
				}
			}
		)
	}
	
	//文件上传
	function upload(){
		//ajax请求局部提交
		//设置参数
		var args={
			//url绝对路径
			url:$("#path").val()+"/upload/common.do",
			//返回类型
			dataType:"text",
			//提交方式
			type:"post",
			success:function(result){
				//设置图片的属性
				$("#img").attr("src",$("#path").val()+"/upload/"+result);
				//将路径设置到隐藏域中
				$("#picurl").val(result);
			}
		}
		//表单局部提交
		$("#jvForm").ajaxSubmit(args);
	}

	
</script>
</head>
<body>
	<input type="hidden" id="path" value="${pageContext.request.contextPath }" ></input>
	<div class="box-positon">
		<div class="rpos">当前位置: 用户管理 - 添加</div>
		<form class="ropt">
			<input type="submit" onclick="this.form.action='list.do';"
				value="返回列表" class="return-button" />
		</form>
		<div class="clear"></div>
	</div>
	<div class="body-box" style="float: right">
		<form name="fm" id="jvForm" action="add.do" method="post" enctype="multipart/form-data">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired"></span> <span class="pn-frequired">${msg}</span>
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 用户名:</td>
						<td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="loginname" id="loginname"  maxlength="100" onblur="chkloginname()"  />
						<span id="resultName"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 密码:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="password" id="password" maxlength="100"
							onblur="chkpassword()" /> <span id="resultPwd"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 确认密码:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="repwd" id="repwd" maxlength="100" />
							 <span id="resultRepwd"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 真实姓名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="realname" id="realname" maxlength="100"
							onblur="chkrealname()" /> <span id="resultRename"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">性别:</td>
						<td width="80%" class="pn-fcontent"><input type="radio"
							name="sex" value="男" checked="checked" />男 <input type="radio"
							name="sex" value="女" />女</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">出生日期:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="Wdate" name="birthday" maxlength="80" onclick="WdatePicker()" />
						</td>
					</tr>
					<%-- <tr>
						<td width="20%" class="pn-flabel pn-flabel-h">部门:</td>
						<td width="80%" class="pn-fcontent"><select name="dept">
								<c:forEach items="${depts}" var="dep">
									<option value="${dep.id}" name="id">${dep.deptname}</option>
								</c:forEach>
						</select></td>
					</tr> --%>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">部门:</td>
						<td width="80%" class="pn-fcontent">
							<select name="dept">
								<c:forEach items="${DLIST}" var="dep1">
									<option value="${dep1.id}">${dep1.name}</option>
								</c:forEach>
							</select>
							<select id="dep2" name="dept.id">
								<c:forEach items="${DLIST2}" var="dep2">
									<option value="${dep2.id}" >${dep2.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">邮箱:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="email" id="email" maxlength="80"
							onblur="chkemail()" /> <span id="resultEmail"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flable pn-flable-h">
							头像：
						</td>
						<td width="80%" class="pn-fcontent">
							<input type="file" name="file" onchange="upload()"></input>
							<img id="img" width="120px" height="120px"  alt="没什么卯月的头像" />
							<!-- 提交图片路径 --> 
							<input type="hidden" name="picurl" id="picurl" />
						</td>
					</tr>
					
				</tbody>
				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2">
							<input type="submit"class="submit" value="提交"  />&nbsp; 
							<input type="reset" class="reset" value="重置" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>