<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
  	
  	<script type="text/javascript">
  		$(function(){
  		//加载show欢迎信息
  		window.setTimeout(function(){
  			$.messager.show({
  				title:${user.user_name},
  				msg:"欢迎回来",
  				timeout:5000,
  				showType:"slide"
  			});
  		},3000);
  			
  		//动态加载ztree
  			var setting = {
				  				data: {
									simpleData: {
										enable: true,
									}
								},
								callback: {
									onClick: function(event, treeId, treeNode){
										if(treeNode.page != undefined){
											var e = $("#aaa").tabs("exists",treeNode.name);
						  				if(e){
						  					$("#aaa").tabs("select",treeNode.name);
						  				}else{
						  					$("#aaa").tabs("add",{
												title:treeNode.name,
												iconCls:'icon-save',
												closable:'true',
												content:'<iframe frameborder="0" width="100%" height="100%" src=${pageContext.request.contextPath }'+treeNode.page+"></iframe>"			
						  					});
						  				}
										}
									}
								}
								
				  			};
				  			//系统管理ztree
				  			var setting1 = {
				  				data: {
									simpleData: {
										enable: true,
									}
								},
								callback: {
									onClick: function(event, treeId, treeNode){
										if(treeNode.page != undefined){
											var e = $("#aaa").tabs("exists",treeNode.name);
						  				if(e){
						  					$("#aaa").tabs("select",treeNode.name);
						  				}else{
						  					$("#aaa").tabs("add",{
												title:treeNode.name,
												iconCls:'icon-save',
												closable:'true',
												content:'<iframe frameborder="0" width="100%" height="100%" src=${pageContext.request.contextPath }'+treeNode.page+"></iframe>"			
						  					});
						  				}
										}
									}
								}
								
				  			};
				  			
				  			
				  			
  								$.ajax({
										url:"${pageContext.request.contextPath }/functionAction_findFunction",
										data:{idd:"${user.id}"},
										contentType:"json",
										dataType:"json",
										success:function(data){
											$.fn.zTree.init($("#ztree"), setting, data);
										}
								});
								
								$.ajax({
										url:"${pageContext.request.contextPath }/json/admin.json",
										contentType:"json",
										dataType:"json",
										success:function(data){
											$.fn.zTree.init($("#ztree1"), setting1, data);
										}
								});
  		});
  		
  		//退出系统
  		function logoutFun(){
  			$.messager.confirm("提示信息", "你真的要走？", function(bool) {
				if(bool){
					location.href="${pageContext.request.contextPath }/userAction_leave"
				}  				
  			});
  		}
  		
  		//修改密码
  		function editPassword() {
			$("#editPwdWindow").window("open");
		}
		
		function check(){
			var bool = $("#editPasswordForm").form("validate");
			if(bool){
				var m1 = $("#txtNewPass").val();
				var m2 = $("#txtRePass").val();
				if(m1 == m2){
					$.ajax({
						url:"${pageContext.request.contextPath }/userAction_editPassword",
						data:{"id":${user.id},"user_pwd":m1},
						success:function(data){
							$.messager.alert("提示信息","修改密码成功,请重新登录!");
							location.href="${pageContext.request.contextPath }/jsp/login.jsp";
						},
						error:function(){
							alert(0);
						}
					});
				}
			}else{
				$.messager.alert("提示信息","两次输入的密码不一致!!");
			}
			
			
		}
		
		function addHoverDom(treeId, treeNode){
			alert(treeNode.tId.length);
		}
		function removeHoverDom(treeId, treeNode){
		}
  	</script>
  <body class="easyui-layout">
    <div title="bos管理系统" style="height:80px" region="north">
    	<div id="sessionInfoDiv"
			style="position: absolute;right: 5px;top:10px;">
			[<strong>${user.user_name }</strong>]，欢迎你！
		</div>
		<div style="position: absolute; right: 5px; bottom: 10px; ">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
			<a class="easyui-menubutton" menu="#layout_north_kzmbMenu" icon="icon-help">控制面板</a>
		</div>
    </div>
    <div title="菜单"  style="width:150px" data-options="region:'west'">
    	<div class="easyui-accordion" data-options="fit:true">
    		<div data-options="iconCls:'icon-save'"  title="基本功能">
    			<ul id="ztree" class="ztree"></ul>
    		</div>
    		<div data-options="iconCls:'icon-save'" title="系统管理">
    			<ul id="ztree1" class="ztree"></ul>
    		</div>
    	</div>
    </div>
    <div data-options="region:'center'">
    	<div id="aaa" class="easyui-tabs" data-options="fit:true">
    	</div>
    </div>
    <div style="height:50px" data-options="region:'south'"></div>
    <div style="width:30px" data-options="region:'east'"></div>
    
    <div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="editPassword()">修改密码</div>
			<div onclick="showAbout()">联系管理员</div>
			<div class="menu-sep"></div>
			<div onclick="logoutFun()">退出系统</div>
	</div class="easyui-window">
	
	<!--  修改密码页面-->
	<div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" modal="true" closed="true" resizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 160px; padding: 5px;
        background: #fafafa">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
               <form id="editPasswordForm">
	                <table cellpadding=3>
	                    <tr>
	                        <td>新密码：</td>
	                        <td><input required="true" data-options="validType:'length[6,10]'" id="txtNewPass" type="Password" class="txt01 easyui-validatebox" /></td>
	                    </tr>
	                    <tr>
	                        <td>确认密码：</td>
	                        <td><input required="true" data-options="validType:'length[6,10]'" id="txtRePass" type="Password" class="txt01 easyui-validatebox" /></td>
	                    </tr>
	                </table>
               </form>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" onclick="check()" >确定</a> 
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>
    
  </body>
</html>
