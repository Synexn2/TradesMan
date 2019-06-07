<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tradesman.* , java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Tradesman App | User Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<% 

ApplicationDAO appDao = new ApplicationDAO();


User user = new User();

	 String userName = request.getParameter("username");
     String password = request.getParameter("password");
if("Login".equals(request.getParameter("submit"))){

	 session.setAttribute("currentUser", user.login(userName, password));
	 String redirectURL = "profile.jsp";
	 response.sendRedirect(redirectURL);

}



%>
<div class="container">
<div class="page-header">
    <h1>User Login <small>Tradesman App :</small></h1>
</div>

<!-- Registration form - START -->
<div class="container">
<div class="row">
<form role = "form" action = "searchResult.jsp">
            	<div class="form-group" >
                    <label for="InputEmail"> Search</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="search" name="search" placeholder="search" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
                    </div>
                </div>
               <input type="submit" name="submit" id="submit" value="Search TradesMan" class="btn btn-info pull-right">
            </form>
</div>
    <div class="row">
        <form role="form" action = "login.jsp">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputName">Enter Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter Username" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Enter Password</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                
                <input type="submit" name="submit" id="submit" value="Login" class="btn btn-info pull-right">
            </div>
        </form>
        
        <div class="col-lg-5 col-md-push-1">
            <div class="col-md-12">
                <div class="alert alert-success">
                    <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                </div>
                <div class="alert alert-danger">
                    <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Registration form - END -->

</div>

</body>
</html>