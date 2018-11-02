<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../javascript/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body class="layui-anim layui-anim-up">
<!--     <div class="x-nav"> -->
<!--       <span class="layui-breadcrumb"> -->
<!--         <a href="">首页</a> -->
<!--         <a href="">演示</a> -->
<!--         <a> -->
<!--           <cite>导航元素</cite></a> -->
<!--       </span> -->
<!--       <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新"> -->
<!--         <i class="layui-icon" style="line-height:30px">ဂ</i></a> -->
<!--     </div> -->
    <div class="x-body">
      <div class="layui-row">
        <div class="layui-form layui-col-md12 x-so">
          <input type="text" name="account"  id="account" placeholder="请输入账号" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" id="search"><i class="layui-icon">&#xe615;</i></button>
        </div>
      </div>
      <xblock>
<!--         <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> -->
        <button class="layui-btn" onclick="x_admin_show('添加用户','addPage',650,460)"><i class="layui-icon"></i>添加</button>
<%--         <span class="x-right" style="line-height:40px">共有数据：${map.count } 条</span> --%>
      </xblock>
      <div id="listData">
      </div>
      </div>
    <script>
      $(function(){
    	  loadList();
      })   
      
      $("#search").on("click",function(){
    	  loadList();
      })
      
      function loadList(){
    	  layui.use('jquery',function(){
    		  var $ = layui.$;
    		  $("#listData").load("./getList",{
    			  account: $("#account").val(),
    			  page: 1,
    			  pageSize: 10,
    			  flag: 1
    		  })
    	  })
      }
      
      
       /*用户-停用*/
      function enable(id,status){
    	   var msg = status==1?"您确定要启用":"您确定要禁用";
           layer.confirm(msg,function(index){
        	  $.post("./updateStatus",{
        		  id:id,
        		  status:status
        	  },function(result){
        		  if(result.code == 0){
	        		  var resMsg = status == 1?"已启用":"已停用";
	        		  layer.msg(resMsg,{icon: 5,time:1000},function(){
	        			  loadList();
	            	  });
        		  }else{
        			  layer.alert(result.msg);
        		  }
        	  })
           });
      }

      /*用户-删除*/
      function mdel(id){
          layer.confirm('确认要删除吗？',function(index){
              $.post("./delete",{
            	  id:id
              },function(result){
            	  if(result.code == 0){
            		  layer.msg('删除成功!',{icon:1,time:1000},function(){
            			  loadList();
            		  });
            	  }else{
            		  layer.alert(result.msg);
            	  }
              })
          });
      }
    </script>
  </body>

</html>