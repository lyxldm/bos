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
		// 授权树初始化
		var setting = {
			data : {
				simpleData : {
					enable : true
				}
			},
			check : {
				enable : true,
			},
			
		};
		
		$.ajax({
			url:"${pageContext.request.contextPath }/json/menu.json",
			contentType:"json",
			dataType:"json",
			success:function(data){
				$.fn.zTree.init($("#functionTree"), setting, data);
			}
		});
		
		
		
		// 点击保存
		$('#save').click(function(){
			var b = $("#roleForm").form("validate");
			if(b){
				var ztree =  $.fn.zTree.getZTreeObj("functionTree"); 
				var nodes = ztree.getCheckedNodes(true);
				var array = new Array();
				for(var i=0;i<nodes.length;i++){
					var id = nodes[i].id;
					array.push(id);
				}
				var ids = array.join(",");
				$("#roleid").val(ids);
				$("#roleForm").submit();
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
			<form id="roleForm" method="post" action="roleAction_add">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">角色信息</td>
					</tr>
					<tr>
						<td width="200">关键字</td>
						<td>
							<input type="text" name="code" class="easyui-validatebox" data-options="required:true" />						
						</td>
					</tr>
					<tr>
						<td>名称</td>
						<td><input type="text" name="name" class="easyui-validatebox" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>描述</td>
						<td>
							<textarea name="description" rows="4" cols="60"></textarea>
						</td>
					</tr>
					<tr>
						<td>授权</td>
						<td>
							<ul id="functionTree" class="ztree"></ul>
						</td>
					</tr>
					<tr>
						<input type="hidden" id="roleid" name="roleIds"/>
					</tr>
					</table>
			</form>
		</div>
</body>
</html>