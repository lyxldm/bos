<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
  	


<script type="text/javascript">
	$(function(){
		$('#save').click(function(){
			$('#form').submit();
		});
		$.ajax({
			url:"${pageContext.request.contextPath}/roleAction_roleAll",
			dataType:"json",
			success:function(data){
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
					$("#selectrole").append('<input name="ids" id="'+id+'" type="checkbox" value="'+id+'"/><lable for="'+id+'">'+name+'</lable>');
				}
			}
		});
	});
</script>	
</head>
<body class="easyui-layout">
	<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
		<div class="datagrid-toolbar">
			<a id="save" icon="icon-save" class="easyui-linkbutton" plain="true" >保存</a>
		</div>
	</div>
    <div region="center" style="overflow:auto;padding:5px;" border="false">
       <form id="form" method="post" action="${pageContext.request.contextPath }/userAction_add">
           <table class="table-edit"  width="95%" align="center">
           		<tr class="title"><td colspan="4">基本信息</td></tr>
	           	<tr><td>用户名:</td><td><input type="text" name="user_name" class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
					<td>密码:</td><td><input type="password" name="user_pwd" class="easyui-validatebox" required="true" validType="minLength[5]" /></td>
				</tr>
				<tr>
					<td>电话:</td><td><input type="text" name="user_phone"  class="easyui-validatebox" required="true" validType="minLength[5]" /></td>
				</tr>
				<tr>
					<td>选择角色</td><td id="selectrole"></td>
				</tr>
           </table>
       </form>
	</div>
</body>
</html>