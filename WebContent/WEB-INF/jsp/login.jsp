<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		
		<!-- 添加jquery使 下面的js代码生效 -->
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<link href="images/favicon.ico" rel="shortcut icon">
		<link rel="stylesheet" type="text/css" href="css/login
		.css"/>
		<style type="text/css">
		   .i{
		       margin-left:20px;
		   }
		</style>
	</head>
	<body>
		<form action="login" method="post">
			<h4>登&nbsp;&nbsp;&nbsp;&nbsp;录</h4>
			<input type="text" name="usercode" required="required" placeholder="用户名" />
			<input type="password" name="password" required="required" placeholder="密码" />
			<div id="verify">
				<input type="text" name="checkCode" required="required" placeholder="验证码" />
				<img id="imgObj" class="i" onclick="changeImg()" alt="验证码"
   					src="${pageContext.request.contextPath}/checkCode">
			
			</div>
			<div id="forget"> <a href="#">自助注册</a> <a href="#">忘记密码</a></div>
			<input id="login" type="submit" value="登       录" />
		</form>
		
<script type="text/javascript">
    $(function() {

    });

    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

</script>
	</body>
	
	${msg }
	${code }
	

</html>
