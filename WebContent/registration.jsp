<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="tradesman.* , java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>Tradesman App | Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<% 

ApplicationDAO appDao = new ApplicationDAO();


		

	 String userName = request.getParameter("userName");
     String password = request.getParameter("password");
     String firstName= request.getParameter("firstName");
     String lastName= request.getParameter("lastName");
     String phoneNumber= request.getParameter("phoneNumber");
     String streetName= request.getParameter("streetName");
     String city= request.getParameter("city");
     String county= request.getParameter("county");
     String postcode= request.getParameter("postcode");
     String country= request.getParameter("country");
     String email= request.getParameter("email");

if("Register".equals(request.getParameter("submit"))){
User user = new User(userName,password,firstName,lastName,phoneNumber,streetName,city,county,postcode,country,email);


appDao.register(user);

}



%>



<div class="container">

<div class="page-header">
    <h1>Registration form <small>Tradesman App</small></h1>
</div>

<!-- Registration form - START -->
<div class="container">
    <div class="row">
        <form role="form" action = "registration.jsp">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputName">Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="userName" id="userName" placeholder="Enter Username" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Password</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Firstname</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter Firstname" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Lastname</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Lastname" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputName"> Email</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="email" id="email" placeholder=" email" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                <div class="form-group">
                    <label for="InputEmail">Phone Number</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone number" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="InputEmail">Street Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="streetName" name="streetName" placeholder="Enter Street Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">City</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="city" name="city" placeholder="Enter City" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">County</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="county" name="county" placeholder="Enter County" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Postcode</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="postcode" name="postcode" placeholder="Enter Postcode" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Country</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="country" name="country" placeholder="Enter Country" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <input type="submit" name="submit" id="submit" value="Register" class="btn btn-info pull-right">
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