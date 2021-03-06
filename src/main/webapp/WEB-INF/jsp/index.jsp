<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>开发配置平台</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
	<link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./javascript/xadmin.js"></script>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.html">开发配置管理</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">${loginUser.name }</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','http://www.zhihuishangjie.com')">个人信息</a></dd>
              <dd><a href="javascript:void(0)" id="logout">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="http://www.zhihuishangjie.com">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>员工管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="developer/getPage">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>员工列表</cite>
                            
                        </a>
                    </li >
<!--                     <li> -->
<!--                         <a _href="member-del.html"> -->
<!--                             <i class="iconfont">&#xe6a7;</i> -->
<!--                             <cite>会员删除</cite> -->
                            
<!--                         </a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="javascript:;"> -->
<!--                             <i class="iconfont">&#xe70b;</i> -->
<!--                             <cite>会员管理</cite> -->
<!--                             <i class="iconfont nav_right">&#xe697;</i> -->
<!--                         </a> -->
<!--                         <ul class="sub-menu"> -->
<!--                             <li> -->
<!--                                 <a _href="xxx.html"> -->
<!--                                     <i class="iconfont">&#xe6a7;</i> -->
<!--                                     <cite>会员列表</cite> -->
                                    
<!--                                 </a> -->
<!--                             </li > -->
<!--                             <li> -->
<!--                                 <a _href="xx.html"> -->
<!--                                     <i class="iconfont">&#xe6a7;</i> -->
<!--                                     <cite>会员删除</cite> -->
                                    
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a _href="xx.html"> -->
<!--                                     <i class="iconfont">&#xe6a7;</i> -->
<!--                                     <cite>等级管理</cite> -->
                                    
<!--                                 </a> -->
<!--                             </li> -->
                            
<!--                         </ul> -->
<!--                     </li> -->
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>订单管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>订单列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="admin-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员列表</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="admin-role.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>角色管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="admin-cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限分类</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="admin-rule.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
      </div>
    </div>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
</body>
</html>
<script>
    (function(){
//     	var $ = layui.$;
    	layui.use("layer",function(){
    		var layer = layui.layer;
    		var $ = layui.$;
    		$("#logout").on("click",function(){
    			layer.confirm("您确定要退出嘛?",function(){
        			$.post("./logout",function(result){
        				if(result.code==0){
        					layer.msg(result.msg,function(){
        						location.href = "./";
                      			return false;
                      		});
        				}else{
        					layer.msg(result.msg,function(){
                      			return false;
                      		});
        				}
        			})
        		},function(){
        			layer.msg("取消退出啦!",function(){
              			return false;
              		});
        		})
    		})
    	})
    	
    })()
</script>