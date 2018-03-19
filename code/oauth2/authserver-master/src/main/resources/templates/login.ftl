<html>
<head>
<link rel="stylesheet" href="css/wro.css"/>
</head>
<body>
	<div class="container">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">用户名:</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">密码:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <button type="submit" class="btn btn-primary">登录</button>
		</form>
	</div>
</body>
</html>