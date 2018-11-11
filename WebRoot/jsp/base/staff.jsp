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
  <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">
	function doAdd(){
		$('#dsa').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	
	
	function doDelete(){
		//获取数据表格中所有选中的行，返回数组对象
		var rows = $("#grid").datagrid("getSelections");
		if(rows.length == 0){
			//没有选中记录，弹出提示
			$.messager.alert("提示信息","请选择需要删除的取派员！","warning");
		}else{
			//选中了取派员,弹出确认框
			$.messager.confirm("删除确认","你确定要删除选中的取派员吗？",function(r){
				if(r){
					
					var array = new Array();
					//确定,发送请求
					//获取所有选中的取派员的id
					for(var i=0;i<rows.length;i++){
						var id = rows[i].id;//json对象
						array.push(id);
					}
					var ids = array.join(",");//1,2,3,4,5
					location.href = "staffAction_deleteBatch?ids="+ids;
				}
			});
		}
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, 
	<shiro:hasPermission name="staff-list">
		{
			id : 'button-delete',
			text : '删除',
			iconCls : 'icon-cancel',
			handler : doDelete
		},
	</shiro:hasPermission>
	{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true,
	},{
		field : 'name',
		title : '姓名',
		width : 120,
		align : 'center'
	}, {
		field : 'telephone',
		title : '手机号',
		width : 120,
		align : 'center'
	}, {
		field : 'haspda',
		title : '是否有PDA',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="1"){
				return "有";
			}else{
				return "无";
			}
		}
	}, {
		field : 'deltag',
		title : '是否作废',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(row.deltag=="0"){
				return "正常使用"
			}else{
				return "已作废";
			}
		}
	}, {
		field : 'standard',
		title : '取派标准',
		width : 120,
		align : 'center'
	}, {
		field : 'station',
		title : '所谓单位',
		width : 200,
		align : 'center'
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		// 取派员信息表格
		$('#grid').datagrid( {
			fit : true,
			border : true,
			rownumbers : true,
			striped : false,
			pageList: [10,20,30],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath }/staffAction_list",
			idField : 'id',
			columns : columns,
			//为数据表格绑定双击事件
			onDblClickRow : doDblClickRow
		});
		
		
	});

	 /*设置zengjia志愿页面  */
		$('#dsa').window({
	        title: '增加取派员',
	        width: 400,
	        modal: true,//遮罩效果
	        shadow: true,//阴影效果
	        closed: true,//关闭
	        height: 400,
	        resizable:false
	    });
	    
	    
	    /*设置更新志愿页面  */
	    $('#dsa').window({
	        title: '更新职员',
	        width: 400,
	        modal: true,//遮罩效果
	        shadow: true,//阴影效果
	        closed: true,//关闭
	        height: 400,
	        resizable:false
	    });

	function doDblClickRow(rowIndex, rowData){
		$("#updataStaff").window("open");
		$("#updateStaffForm").form("load",rowData);
	}
</script>	
</head>
<body class="easyui-layout">
	<div  region="center" border="false">
		<table id="grid"></table>
	</div>
	
	<div id="dsa" closed="true" style=""width:500px;height:100px" class="easyui-window">
		<div region="north" style="height:31px" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addStaffForm" action="staffAction_save" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script type="text/javascript">
								$(function(){
									//为保存按钮绑定事件
									$("#save").click(function(){
										//表单校验，如果通过，提交表单
										var v = $("#addStaffForm").form("validate");
										if(v){
										
											//$("#addStaffForm").form("submit");
											$("#addStaffForm").submit();
										}
									});
									
									var reg = /^1[3|4|5|7|8][0-9]{9}$/;
									//扩展手机号校验规则
									$.extend($.fn.validatebox.defaults.rules, { 
										telephone: { 
											validator: function(value,param){ 
											return reg.test(value);
										}, 
											message: '手机号输入有误！' 
										}
										}); 
									});
							</script>
						<input type="text" data-options="validType:'telephone'" 
							name="telephone" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
	
		<!--修改志愿页面  -->
	<div id="updataStaff" closed="true" style=""width:500px;height:100px" class="easyui-window">
		<div region="north" style="height:31px" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="saveUpdate" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>

		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="updateStaffForm" action="staffAction_staffUpdate" method="post">
				<table class="table-edit" width="80%" align="center">
					
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>id</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
							<script type="text/javascript">
								$(function(){
									//为保存按钮绑定事件
									$("#saveUpdate").click(function(){
										//表单校验，如果通过，提交表单
										var v = $("#updateStaffForm").form("validate");
										if(v){
											//$("#addStaffForm").form("submit");
											$("#updateStaffForm").submit();
										}
									});
									
									
								});
							</script>
						<input type="text" data-options="validType:'telephone'" 
							name="telephone" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
	
	
	
	
	
</body>
</html>	