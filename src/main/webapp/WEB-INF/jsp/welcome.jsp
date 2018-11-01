<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>开发配置</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <style type="text/css">
        /*背景局部清晰*/
		.bg{
		    width: 100%;
		    height: 100%;
/*  		    position: relative;  */
            background-repeat: no-repeat;
            background-attachment:fixed;
		    background-image: url(image/timg1.jpg);
		    padding: 1px;
		    box-sizing: border-box;
		    background-position: 50% 50%;
		    margin: 0;
		    padding: 0;
		    background-size: cover;
		    background-repeat: no-repeat;
		}
		.bg:after{
		    content: "";
		    width:100%;
		    height:100%;
		    position: absolute;
		    left:0;
		    top:0;
		    background: inherit;
		    filter: blur(2px);
        }

        .word{
            position:absolute;
            right:12em;
            top:10em;
            
        }
        .word1{
            position:absolute;
            right:14.5em;
            top:13em;
        }
        .word p,.word1 p{
           margin:0 auto;
           width:20px;
           line-height:24px;
           font-size:24px;
           color: #EEE;
        }
        </style>
    </head>
    <body>
        <div class="bg">
	        
        </div>
        <div class="x-body layui-anim layui-anim-up" style="z-index:20;">
	        <blockquote class="layui-elem-quote">欢迎管理员：
	        <span class="x-red">${loginUser.name }</span>！当前时间:<span id="time">${time }</span></blockquote>
	    </div>
	    <div class="word">
	         <p>人生若只如初见</p>
	        
	    </div>
	    <div class="word1">
	          <p>何事秋风悲画扇</p>
	    </div>
	    
    </body>
</html>
<script>
Date.prototype.Format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  
  $(function(){
	  var t = $("#time").text();
	  if(!t){
		  t = new Date().getTime();
	  }else{
		  t = new Date(t).getTime();
	  }
	  layui.use("jquery",function(){
		  var $ = layui.$;
		  t = new Date(t);
		  setInterval(function(){
			  t = Number(t)+1000;
		      $("#time").text(new Date(t).Format("yyyy-MM-dd hh:mm:ss"));
		  },1e3);
		  var f = Math.floor(Math.random()*7+1);
		  $(".bg").css("background-image","url(image/timg"+f+".jpg)")
	  })
	  var wd = [];
	  wd.push({
		  a:'人生若只如初见',
		  b:'何事秋风悲画扇'
	  });
	  wd.push({
		  a:'但愿人长久',
		  b:'千里共婵娟'
	  });
	  wd.push({
		  a:'忽如一夜春风来',
		  b:'千树万树梨花开'
	  });
	  wd.push({
		  a:'出师未捷身先死',
		  b:'长使英雄泪沾襟'
	  })
	  wd.push({
		  a:'当断不断',
		  b:'反受其乱'
	  })
	  var s = Math.floor(Math.random()*5+1);
	  $(".word p").text(wd[s-1].a);
	  $(".word1 p").text(wd[s-1].b);
	  
  })


</script>