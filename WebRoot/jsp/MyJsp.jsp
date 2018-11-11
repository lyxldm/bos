<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
  var index = -1;
  function aa(){
  	
  	var select = $("#grid").datagrid("getSelections");
  	if(select.length == 1){
  		index = $("#grid").datagrid("getRowIndex",select[0 ]);
  		$("#grid").datagrid("beginEdit",index);
  	}else{
  		alert(111);
  	}
  }
  function bb(){
  	$("#grid").datagrid("insertRow",{index:0,row:{}});
  }
  function cc(){
  	$("#grid").datagrid("endEdit",index);
  }
  	$(function(){
  		$("#grid").datagrid({
  		url:"${pageContext.request.contextPath }/json/staff.json",
  		columns:[[
  			{title:"t1",field:"id"},
  			{width:150,title:"t2",field:"name",editor:{type:"numberbox",options:{}}},
  			{title:"t3",field:"haspda",width:100},
  		]],
  		toolbar:[
  			{id:"a",text:"zj",handler:aa},	
  			{id:"d",text:"sc",handler:bb},
  			{id:"d1",text:"sc2",handler:cc}
  		]
  	});
  	});
  </script>
  <body class="easyui-layout">
    <div region="center">
    	<table id="grid"></table>
    </div>
  </body>
</html>
